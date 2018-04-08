package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
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
        DefaultRegister a = new DefaultRegister(11);
        DefaultRegister programInterrupt = new DefaultRegister(0);
        new DIV(a, new DefaultRegister(5), programInterrupt).execute();
        assertEquals(a.toInt(), 2);
        assertEquals(programInterrupt.toInt(), 0);
    }

    @Test
    public void dividesABy0() {
        DefaultRegister a = new DefaultRegister(16);
        DefaultRegister programInterrupt = new DefaultRegister(0);
        new DIV(a, new DefaultRegister(0), programInterrupt).execute();
        assertEquals(a.toInt(), 16);
        assertEquals(programInterrupt.toInt(), 2);
    }
}