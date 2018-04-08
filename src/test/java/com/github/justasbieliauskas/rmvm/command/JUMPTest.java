package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
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
        DefaultRegister counter = new DefaultRegister(96);
        DefaultRegister error = new DefaultRegister(0);
        new JUMP(counter, new DefaultRegister(234), new DefaultRegister(84), error).execute();
        assertEquals(counter.toInt(), 1020);
        assertEquals(error.toInt(), 0);
    }

    @Test
    public void setsBadAddress() {
        DefaultRegister counter = new DefaultRegister(96);
        DefaultRegister error = new DefaultRegister(0);
        new JUMP(counter, new DefaultRegister(235), new DefaultRegister(84), error).execute();
        assertEquals(counter.toInt(), 96);
        assertEquals(error.toInt(), 1);
    }
}