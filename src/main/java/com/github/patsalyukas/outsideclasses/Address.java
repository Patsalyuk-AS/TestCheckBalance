package com.github.patsalyukas.outsideclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {

    private final String region;
    private final String city;
    private final String street;
    private final String house;
    private final String flat;

    public Address(String region, String city, String street, String house) {
        this(region, city, street, house, "-");
    }


}
