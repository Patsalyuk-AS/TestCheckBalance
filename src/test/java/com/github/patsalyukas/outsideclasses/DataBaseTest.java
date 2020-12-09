package com.github.patsalyukas.outsideclasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    DataBase<Card> dataBase = new DataBase<>(new BankCardFactory());
    Card card1 = new BankCard("IVAN", "PETROV", "4256123542131234", "12/21", "1532", "652", BankCardType.DEBET);
    Card card2 = new BankCard("IVAN", "PETROV", "4256123542134526", "12/21", "1532", "652", BankCardType.DEBET);
    Balance balance = new Balance(Currency.RUB, new BigDecimal("15000"));

    @BeforeEach
    void setUp() throws IllegalCardParametersException {
        dataBase.inializeDataBase();
    }

    @Test
    void validateCard() {
        assertTrue(dataBase.validateCard(card1));
        assertFalse(dataBase.validateCard(card2));
    }

    @Test
    void getBalance() throws BankException {
        assertEquals(balance, dataBase.getBalance(card1));

    }


}