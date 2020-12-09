package com.github.patsalyukas.outsideclasses;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class Balance {

    private final Currency currency;
    private final BigDecimal sum;

}
