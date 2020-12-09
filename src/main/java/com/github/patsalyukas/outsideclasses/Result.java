package com.github.patsalyukas.outsideclasses;

public enum Result {

    SUCCESS(1),
    FAILURE(2);

    private int code;

    Result(int code) {
        this.code = code;
    }

}
