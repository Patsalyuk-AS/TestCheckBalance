package com.github.patsalyukas.client;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.github.patsalyukas.outsideclasses.*;
import com.github.patsalyukas.device.SelfServiceDevice;

public class CheckerBalanceOnSelfServiceDevice extends ClientOfSelfServiceDevice {

    private Balance balance;

    public CheckerBalanceOnSelfServiceDevice(Passport passport, SelfServiceDevice selfServiceDevice, Card card) {
        super(passport, selfServiceDevice, card);
        balance = new Balance(Currency.RUB, new BigDecimal("0"));
    }

    public Balance checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        SelfServiceDevice selfServiceDevice = getSelfServiceDevice();
        goToSelfServiceDevice();
        insertCard();
        balance = selfServiceDevice.returnBalance(getCard());
        return balance;
    }

}
