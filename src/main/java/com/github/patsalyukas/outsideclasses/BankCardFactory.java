package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankCardFactory implements FactoryForCards {

    private static Pattern patternCardNumber = Pattern.compile("^\\d{16}$");
    private static Pattern patternPIN = Pattern.compile("^\\d{4}$");
    private static Pattern patternCVI = Pattern.compile("^\\d{3}$");

    @Override
    public Card createCard(String firstName, String lastName, String cardNumber, String expDate, String pin, String cvi, BankCardType type) throws IllegalCardParametersException {
        validateCardParameters(cardNumber, pin, cvi);
        return new BankCard(firstName, lastName, cardNumber, expDate, pin, cvi, type);
    }

    @Override
    public Balance createBalance(Currency currency, BigDecimal sum) {
        return new Balance(currency, sum);
    }

    private void validateCardParameters(String cardNumber, String pin, String cvi) throws IllegalCardParametersException {
        Matcher matcherCardNumber = patternCardNumber.matcher(cardNumber);
        Matcher matcherPIN = patternPIN.matcher(pin);
        Matcher matcherCVI = patternCVI.matcher(cvi);
        if (!(matcherCardNumber.matches() && matcherCVI.matches() && matcherPIN.matches())) {
            throw new IllegalCardParametersException("Illegal card parameters!");
        }
    }

}
