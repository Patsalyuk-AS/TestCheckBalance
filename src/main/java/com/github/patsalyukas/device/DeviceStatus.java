package com.github.patsalyukas.device;

public enum DeviceStatus {

    BAD(0),
    OK(1);

    private int code;

    DeviceStatus(int code) {
        this.code = code;
    }
}
