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
    public void performsAnd() throws Exception {
        Register a = new Register(42);
        Register status = new Register(7);
        new AND(a, () -> 98, status).execute();
        assertEquals(a.toInt(), 34);
        assertEquals(status.toInt(), 0);
    }

    @Test
    public void performsAndAndSetsZero() throws Exception {
        Register status = new Register(0);
        new AND(new Register(21), () -> 10, status).execute();
        assertEquals(status.toInt(), 1);
    }
}