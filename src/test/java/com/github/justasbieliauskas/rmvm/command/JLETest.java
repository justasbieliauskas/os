package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link JLE}.
 *
 * @author Justas Bieliauskas
 */
public class JLETest
{
    @Test
    public void jumpsOnZeroAndCarry() {
        DefaultRegister counter = new DefaultRegister(96);
        new JLE(
            counter,
            new DefaultRegister(6),
            new DefaultRegister(84),
            new DefaultRegister(0),
            new DefaultRegister(3)
        ).execute();
        assertNotEquals(counter.toInt(), 96);
    }

    @Test
    public void doesNotJumpOnZero0() {
        DefaultRegister counter = new DefaultRegister(96);
        new JLE(
            counter,
            new DefaultRegister(6),
            new DefaultRegister(84),
            new DefaultRegister(0),
            new DefaultRegister(2)
        ).execute();
        assertEquals(counter.toInt(), 100);
    }

    @Test
    public void doesNotJumpOnCarry0() {
        DefaultRegister counter = new DefaultRegister(96);
        new JLE(
            counter,
            new DefaultRegister(6),
            new DefaultRegister(84),
            new DefaultRegister(0),
            new DefaultRegister(1)
        ).execute();
        assertEquals(counter.toInt(), 100);
    }
}