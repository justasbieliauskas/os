package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
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
        Register a = new Register(100);
        Register b = new Register(100);
        Register status = new Register(2);
        new COMP(a, b, status).execute();
        assertEquals(status.toInt(), 1);
    }

    @Test
    public void aIsGreaterThanB() {
        Register a = new Register(120);
        Register b = new Register(100);
        Register status = new Register(3);
        new COMP(a, b, status).execute();
        assertEquals(status.toInt(), 0);
    }

    @Test
    public void aIsLessThanB() {
        Register a = new Register(80);
        Register b = new Register(100);
        Register status = new Register(1);
        new COMP(a, b, status).execute();
        assertEquals(status.toInt(), 2);
    }
}