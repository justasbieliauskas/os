package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.arithmetic.COMP;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link COMP}.
 *
 * @author Justas Bieliauskas
 */
public class COMPTest
{
    @Test
    public void aEqualsB() {
        DefaultRegister a = new DefaultRegister(100);
        DefaultRegister b = new DefaultRegister(100);
        DefaultRegister status = new DefaultRegister(2);
        new COMP(a, b, status).execute();
        assertEquals(status.toInt(), 1);
    }

    @Test
    public void aIsGreaterThanB() {
        DefaultRegister a = new DefaultRegister(120);
        DefaultRegister b = new DefaultRegister(100);
        DefaultRegister status = new DefaultRegister(3);
        new COMP(a, b, status).execute();
        assertEquals(status.toInt(), 0);
    }

    @Test
    public void aIsLessThanB() {
        DefaultRegister a = new DefaultRegister(80);
        DefaultRegister b = new DefaultRegister(100);
        DefaultRegister status = new DefaultRegister(1);
        new COMP(a, b, status).execute();
        assertEquals(status.toInt(), 2);
    }
}