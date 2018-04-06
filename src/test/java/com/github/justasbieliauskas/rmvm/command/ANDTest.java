package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link AND}.
 *
 * @author Justas Bieliauskas
 */
public class ANDTest
{
    @Test
    public void changesZeroTo1() {
        Register a = new Register(42);
        Register b = new Register(20);
        Register status = new Register(6);
        new AND(a, b, status).execute();
        assertEquals(a.toInt(), 0);
        assertEquals(status.toInt(), 1);
    }

    @Test
    public void changesZeroTo0() {
        Register a = new Register(85);
        Register b = new Register(65);
        Register status = new Register(7);
        new AND(a, b, status).execute();
        assertEquals(a.toInt(), 65);
        assertEquals(status.toInt(), 0);
    }
}