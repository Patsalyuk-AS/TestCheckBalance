package com.github.patsalyukas.client;

import lombok.Getter;
import lombok.Setter;
import com.github.patsalyukas.outsideclasses.*;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;

@Getter
@Setter
public class ClientOfSelfServiceDevice {

    private boolean haveGoneToSSD;
    private boolean cardInserted;
    private Passport passport;
    private SelfServiceDevice selfServiceDevice;
    private Card card;

    public ClientOfSelfServiceDevice(Passport passport, SelfServiceDevice selfServiceDevice, Card card) {
        this.passport = passport;
        this.selfServiceDevice = selfServiceDevice;
        this.card = card;
    }

    public Result goToSelfServiceDevice() {
        if (haveGoneToSSD) return Result.SUCCESS;
        Result result = Moving.move(Wish.YES);
        if (result == Result.SUCCESS) haveGoneToSSD = true;
        return result;
    }

    public Result insertCard() throws SelfServiceDeviceBrokenException {
        if (cardInserted) return Result.SUCCESS;
        Result result = selfServiceDevice.takeCard(card);
        if (result == Result.SUCCESS) cardInserted = true;
        return result;
    }

    public Result getBackCard() throws SelfServiceDeviceBrokenException {
        Result result = selfServiceDevice.giveBackCard(card);
        if (result == Result.SUCCESS) cardInserted = false;
        return result;
    }

}
