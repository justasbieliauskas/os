package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.arithmetic.AND;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
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
        DefaultRegister a = new DefaultRegister(42);
        DefaultRegister b = new DefaultRegister(20);
        DefaultRegister status = new DefaultRegister(6);
        new AND(a, b, status).execute();
        assertEquals(a.toInt(), 0);
        assertEquals(status.toInt(), 1);
    }

    @Test
    public void changesZeroTo0() {
        DefaultRegister a = new DefaultRegister(85);
        DefaultRegister b = new DefaultRegister(65);
        DefaultRegister status = new DefaultRegister(7);
        new AND(a, b, status).execute();
        assertEquals(a.toInt(), 65);
        assertEquals(status.toInt(), 0);
    }
}