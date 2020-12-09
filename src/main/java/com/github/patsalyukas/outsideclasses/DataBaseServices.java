package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;

public interface DataBaseServices<E extends Card> {

    boolean validateCard(E e);

    Balance getBalance(E e) throws BankException;

    void showHistoryOfRequestsOfBalances();

    void addCardToDataBase(String firstName, String lastName, String cardNumber, String expDate, String PIN, String CVI, BankCardType type, Currency currency, BigDecimal sum) throws IllegalCardParametersException;

    void handleBankException(BankException exception);

}
