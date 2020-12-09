package com.github.patsalyukas.outsideclasses;

public enum Currency {

    RUB(1, "RusRubl"),
    USD(2, "USDol");

    private int code;
    private String name;

    Currency(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
