package com.github.patsalyukas;

import com.github.patsalyukas.client.CheckerBalanceOnSelfServiceDevice;
import com.github.patsalyukas.client.Passport;
import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.*;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;

@Slf4j
public class Main {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        log.info("Starting application.");
        DataBase<Card> dataBase = new DataBase<>(new BankCardFactory());
        try {
            dataBase.inializeDataBase();
        } catch (IllegalCardParametersException exception) {
            dataBase.handleBankException(exception);
        }

        Address clientAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "124a", "54");
        Address atmAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        Passport clientPassport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), clientAddress);
        Card card = new BankCard("PETR", "IVANOV", "4256123542134526", "30/12", "1020", "152", BankCardType.DEBET);
        SelfServiceDevice atm = new ATM(100000, atmAddress, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        CheckerBalanceOnSelfServiceDevice checkerBalanceOnSelfServiceDevice = new CheckerBalanceOnSelfServiceDevice(clientPassport, atm, card);
        try {
            log.info(checkerBalanceOnSelfServiceDevice.checkBalance().toString());
            checkerBalanceOnSelfServiceDevice.getBackCard();
            log.info(checkerBalanceOnSelfServiceDevice.checkBalance().toString());
        } catch (BankException exception) {
            atm.handleError(exception);
        }
        dataBase.showHistoryOfRequestsOfBalances();
        log.info("Finishing application.");
    }

}
