package com.github.patsalyukas.outsideclasses;

import lombok.Value;

@Value
public class BankCard implements Card {

    private final String firstName;
    private final String lastName;
    private final String cardNumber;
    private final String expDate;
    private final String PIN;
    private final String CVI;
    private final BankCardType type;

    @Override
    public String getNumber() {
        return (getCardNumber());
    }

}
