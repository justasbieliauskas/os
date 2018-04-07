package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link JUMP}.
 *
 * @author Justas Bieliauskas
 */
public class JUMPTest
{
    @Test
    public void setsGoodAddress() {
        Register counter = new Register(96);
        Register error = new Register(0);
        new JUMP(counter, new Register(234), new Register(84), error).execute();
        assertEquals(counter.toInt(), 1020);
        assertEquals(error.toInt(), 0);
    }

    @Test
    public void setsBadAddress() {
        Register counter = new Register(96);
        Register error = new Register(0);
        new JUMP(counter, new Register(235), new Register(84), error).execute();
        assertEquals(counter.toInt(), 96);
        assertEquals(error.toInt(), 1);
    }
}