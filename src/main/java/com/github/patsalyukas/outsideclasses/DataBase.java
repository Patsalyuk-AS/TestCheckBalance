package com.github.patsalyukas.outsideclasses;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
public class DataBase<E extends Card> implements DataBaseServices<E> {

    private final Map<Card, Balance> cards = new HashMap<>();
    private final FactoryForCards factoryForCards;
    private final Set<E> requestsOfBalances = new HashSet<>(20);

    public DataBase(FactoryForCards factoryForCards) {
        this.factoryForCards = factoryForCards;
    }

    @Override
    public boolean validateCard(E e) {
        return cards.containsKey(e);
    }

    @Override
    public Balance getBalance(E e) throws BankException {
        if (!validateCard(e)) {
            throw new NotValidCardException("The card is invalid!");
        }
        checkRepeatedRequestOfBalance(e);
        requestsOfBalances.add(e);
        return cards.get(e);

    }

    @Override
    public void showHistoryOfRequestsOfBalances() {
        Stream<E> cardStream = requestsOfBalances.stream();
        cardStream.forEach(card -> log.info(card.toString()));
    }

    @Override
    public void addCardToDataBase(String firstName, String lastName, String cardNumber, String expDate, String pin, String cvi, BankCardType type, Currency currency, BigDecimal sum) throws IllegalCardParametersException {
        cards.put(factoryForCards.createCard(firstName, lastName, cardNumber, expDate, pin, cvi, type), factoryForCards.createBalance(currency, sum));
    }

    @Override
    public void handleBankException(BankException exception) {
        log.warn(exception.toString());
    }

    private void checkRepeatedRequestOfBalance(E e) throws RepeatRequestOfBalanceException {
        if (requestsOfBalances.contains(e)) {
            throw new RepeatRequestOfBalanceException("The request has already existed.");
        }
    }

    //вспомогательный метод для наполнения базы
    public void inializeDataBase() throws IllegalCardParametersException {
        addCardToDataBase("IVAN", "PETROV", "4256123542131234", "12/21", "1532", "652", BankCardType.DEBET, Currency.RUB, new BigDecimal("15000"));
        addCardToDataBase("PETR", "IVANOV", "4256123542134526", "30/12", "1020", "152", BankCardType.DEBET, Currency.RUB, new BigDecimal("30000"));
        addCardToDataBase("SERGEY", "SIDOROV", "4256123542137536", "15/22", "2534", "752", BankCardType.DEBET, Currency.RUB, new BigDecimal("1000"));
        addCardToDataBase("ELENA", "IVANOVA", "4256123542131526", "05/22", "8563", "632", BankCardType.DEBET, Currency.RUB, new BigDecimal("5000"));
        addCardToDataBase("OXANA", "PETROVA", "4256123542131010", "24/22", "1145", "752", BankCardType.DEBET, Currency.RUB, new BigDecimal("4000"));
        addCardToDataBase("SVETLANA", "SIDOROVA", "4256123542132233", "11/21", "5462", "156", BankCardType.DEBET, Currency.RUB, new BigDecimal("2000"));

    }

}
