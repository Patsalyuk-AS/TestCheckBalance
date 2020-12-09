package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;

public interface FactoryForCards {
    Card createCard(String firstName, String lastName, String cardNumber, String expDate, String PIN, String CVI, BankCardType type) throws IllegalCardParametersException;

    Balance createBalance(Currency currency, BigDecimal sum);
}
