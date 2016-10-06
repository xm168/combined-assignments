package com.cooksys.ftd.assignment.day.one;

import org.junit.Test;

import static com.cooksys.ftd.assignment.day.one.FizzBuzz.*;
import static org.junit.Assert.*;

public class FizzBuzzTests {

    @Test
    public void dividesTest() {
        assertTrue(divides(3, 3));
        assertTrue(divides(5, 5));
        assertTrue(divides(15, 3));
        assertTrue(divides(15, 5));

        assertFalse(divides(1, 3));
        assertFalse(divides(2, 3));
        assertFalse(divides(4, 3));
        assertFalse(divides(5, 3));

        assertFalse(divides(1, 5));
        assertFalse(divides(2, 5));
        assertFalse(divides(3, 5));
        assertFalse(divides(4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dividesExceptionTest() {
        divides(0, 0);
    }

    @Test
    public void messageTest() {
        assertEquals("3: Fizz", message(3));
        assertEquals("5: Buzz", message(5));
        assertEquals("15: FizzBuzz", message(15));
        assertNull(message(1));
    }

    @Test
    public void messagesTest() {
        assertArrayEquals(new String[]{}, messages(3, 3));
        assertArrayEquals(new String[]{"3: Fizz"}, messages(3, 4));
        assertArrayEquals(new String[]{"3: Fizz"}, messages(3, 5));
        assertArrayEquals(new String[]{"3: Fizz", "5: Buzz"}, messages(3, 6));
        assertArrayEquals(new String[]{"3: Fizz", "5: Buzz", "6: Fizz"}, messages(3, 7));
        assertArrayEquals(new String[]{"12: Fizz", "15: FizzBuzz"}, messages(12, 16));
    }

    @Test(expected = IllegalArgumentException.class)
    public void messagesExceptionTest() {
        messages(20, 19);
    }
}
