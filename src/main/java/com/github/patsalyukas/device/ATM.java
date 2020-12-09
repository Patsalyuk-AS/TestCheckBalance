package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;
import lombok.Value;

@Value
public class ATM implements SelfServiceDevice {

    private final int numberATM;
    private final Address addressATM;
    private final DataBaseServices<Card> dataBase;
    private final Reliability reliability;

    @Override
    public Result takeCard(Card card) {
        try {
            checkForDamage();
        } catch (SelfServiceDeviceBrokenException exception) {
            return Result.FAILURE;
        }
        return (dataBase.validateCard(card) ? Result.SUCCESS : Result.FAILURE);
    }

    @Override
    public Balance returnBalance(Card card) throws BankException {
        try {
            checkForDamage();
            return (dataBase.getBalance(card));
        } catch (SelfServiceDeviceBrokenException exception) {
            throw exception;
        } catch (NotValidCardException | RepeatRequestOfBalanceException exception){
            giveBackCard(card);
            throw exception;
        }
    }

    @Override
    public Result giveBackCard(Card card) {
        try {
            checkForDamage();
        } catch (SelfServiceDeviceBrokenException exception) {
            return Result.FAILURE;
        }
        return Result.SUCCESS;
    }

    @Override
    public void handleError(BankException exception) {
        dataBase.handleBankException(exception);
    }

    private void checkForDamage() throws SelfServiceDeviceBrokenException {
        if (reliability.checkDeviceStatus() == DeviceStatus.BAD) {
            throw new SelfServiceDeviceBrokenException("I am out of order!");
        }
    }

}
