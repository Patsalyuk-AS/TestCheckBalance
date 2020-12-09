package com.github.patsalyukas.outsideclasses;

import com.github.patsalyukas.client.Wish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingTest {

    @Test
    void move() {
        assertEquals(Result.SUCCESS, Moving.move(Wish.YES));
        assertEquals(Result.FAILURE, Moving.move(Wish.NO));
    }
}