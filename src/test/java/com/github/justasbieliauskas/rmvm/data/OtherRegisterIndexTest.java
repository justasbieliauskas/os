package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link OtherRegisterIndex}.
 *
 * @author Justas Bieliauskas
 */
public class OtherRegisterIndexTest
{
    @Test
    public void convertsStringToRightIndex() {
        assertEquals(new OtherRegisterIndex("ST").toInt(), 4);
        assertEquals(new OtherRegisterIndex("IC").toInt(), 5);
        assertEquals(new OtherRegisterIndex("SI").toInt(), 6);
        assertEquals(new OtherRegisterIndex("PI").toInt(), 7);
        assertEquals(new OtherRegisterIndex("TI").toInt(), 8);
        assertEquals(new OtherRegisterIndex("CS").toInt(), 9);
        assertEquals(new OtherRegisterIndex("PTR").toInt(), 10);
    }
}