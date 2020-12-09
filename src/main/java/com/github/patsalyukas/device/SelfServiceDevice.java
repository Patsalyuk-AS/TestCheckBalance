package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;

public interface SelfServiceDevice {

    Result takeCard(Card card) throws SelfServiceDeviceBrokenException;

    Balance returnBalance(Card card) throws BankException;

    Result giveBackCard(Card card) throws SelfServiceDeviceBrokenException;

    void handleError(BankException exception);

}
