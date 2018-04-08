package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link RegisterIndex}.
 *
 * @author Justas Bieliauskas
 */
public class RegisterIndexTest
{
    @Test
    public void convertsStringToIndex() {
        assertEquals(new RegisterIndex("A").toInt(), 0);
        assertEquals(new RegisterIndex("B").toInt(), 1);
        assertEquals(new RegisterIndex("C").toInt(), 2);
        assertEquals(new RegisterIndex("D").toInt(), 3);
        assertEquals(new RegisterIndex("ST").toInt(), 4);
        assertEquals(new RegisterIndex("IC").toInt(), 5);
        assertEquals(new RegisterIndex("SI").toInt(), 6);
        assertEquals(new RegisterIndex("PI").toInt(), 7);
        assertEquals(new RegisterIndex("TI").toInt(), 8);
        assertEquals(new RegisterIndex("CS").toInt(), 9);
        assertEquals(new RegisterIndex("PTR").toInt(), 10);
    }
}