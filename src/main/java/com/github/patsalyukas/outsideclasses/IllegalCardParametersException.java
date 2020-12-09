package com.github.patsalyukas.outsideclasses;

public class IllegalCardParametersException extends BankException {

    public IllegalCardParametersException() {
    }

    public IllegalCardParametersException(String message) {
        super(message);
    }

    public IllegalCardParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalCardParametersException(Throwable cause) {
        super(cause);
    }

    public IllegalCardParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
