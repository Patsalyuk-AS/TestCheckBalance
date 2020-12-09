package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface SelfServiceDevice {

    Result takeCard(Card card) throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    Balance returnBalance(Card card) throws BankException, NoSuchProviderException, NoSuchAlgorithmException;

    Result giveBackCard(Card card) throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    void handleError(BankException exception);

}
