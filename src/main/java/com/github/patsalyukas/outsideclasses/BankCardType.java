package com.github.patsalyukas.outsideclasses;

public enum BankCardType {
    DEBET(1, "DebetCard"),
    CREDIT(2, "CreditCard");

    private int code;
    private String name;

    BankCardType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
