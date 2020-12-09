package com.github.patsalyukas.client;

public enum Wish {

    NO (0),
    YES(1);

    private int code;

    Wish(int code) {
        this.code = code;
    }
}
