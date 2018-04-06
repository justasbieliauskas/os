package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link DIV}.
 *
 * @author Justas Bieliauskas
 */
public class DIVTest
{
    @Test
    public void dividesAByB() {
        Register a = new Register(11);
        Register programInterrupt = new Register(0);
        new DIV(a, new Register(5), programInterrupt).execute();
        assertEquals(a.toInt(), 2);
        assertEquals(programInterrupt.toInt(), 0);
    }

    @Test
    public void dividesABy0() {
        Register a = new Register(16);
        Register programInterrupt = new Register(0);
        new DIV(a, new Register(0), programInterrupt).execute();
        assertEquals(a.toInt(), 16);
        assertEquals(programInterrupt.toInt(), 2);
    }
}