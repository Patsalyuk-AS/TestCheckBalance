package com.github.patsalyukas.client;

import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckerBalanceOnSelfServiceDeviceTest {

    Card card = new BankCard("IVAN", "PETROV", "4256123542131234", "12/21", "1532", "652", BankCardType.DEBET);
    DataBase<Card> dataBase = new DataBase<>(new BankCardFactory());
    Address address = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
    Passport passport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), address);
    SelfServiceDevice selfServiceDevice = new ATM(100000, address, dataBase, new ReliabilityOfSelfServiceDevice(1000));
    CheckerBalanceOnSelfServiceDevice client = new CheckerBalanceOnSelfServiceDevice(passport, selfServiceDevice, card);
    Balance balance = new Balance(Currency.RUB, new BigDecimal("15000"));

    @BeforeEach
    void setUp() throws IllegalCardParametersException {
        dataBase.inializeDataBase();
    }

    @Test
    void checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(balance, client.checkBalance());
    }
}