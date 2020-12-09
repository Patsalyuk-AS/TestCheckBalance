package com.github.patsalyukas.outsideclasses;

import lombok.Value;

@Value
public class BankCard implements Card {

    private final String firstName;
    private final String lastName;
    private final String cardNumber;
    private final String expDate;
    private final String pin;
    private final String cvi;
    private final BankCardType type;

    @Override
    public String getNumber() {
        return (getCardNumber());
    }

}
