package com.github.patsalyukas.outsideclasses;

public class NotValidCardException extends BankException {

    public NotValidCardException() {
    }

    public NotValidCardException(String message) {
        super(message);
    }

    public NotValidCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidCardException(Throwable cause) {
        super(cause);
    }

    public NotValidCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
