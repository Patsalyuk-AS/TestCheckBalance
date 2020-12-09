package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankCardFactory implements FactoryForCards {

    private static Pattern patternCardNumber = Pattern.compile("^\\d{16}$");
    private static Pattern patternPIN = Pattern.compile("^\\d{4}$");
    private static Pattern patternCVI = Pattern.compile("^\\d{3}$");

    @Override
    public Card createCard(String firstName, String lastName, String cardNumber, String expDate, String PIN, String CVI, BankCardType type) throws IllegalCardParametersException {
        validateCardParameters(cardNumber, PIN, CVI);
        return new BankCard(firstName, lastName, cardNumber, expDate, PIN, CVI, type);
    }

    @Override
    public Balance createBalance(Currency currency, BigDecimal sum) {
        return new Balance(currency, sum);
    }

    private void validateCardParameters(String cardNumber, String PIN, String CVI) throws IllegalCardParametersException {
        Matcher matcherCardNumber = patternCardNumber.matcher(cardNumber);
        Matcher matcherPIN = patternPIN.matcher(PIN);
        Matcher matcherCVI = patternCVI.matcher(CVI);
        if (!(matcherCardNumber.matches() && matcherCVI.matches() && matcherPIN.matches())) {
            throw new IllegalCardParametersException("Illegal card parameters!");
        }
    }

}
