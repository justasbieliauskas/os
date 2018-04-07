package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
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
        Register counter = new Register(96);
        new JLE(
            counter,
            new Register(6),
            new Register(84),
            new Register(0),
            new Register(3)
        ).execute();
        assertNotEquals(counter.toInt(), 96);
    }

    @Test
    public void doesNotJumpOnZero0() {
        Register counter = new Register(96);
        new JLE(
            counter,
            new Register(6),
            new Register(84),
            new Register(0),
            new Register(2)
        ).execute();
        assertEquals(counter.toInt(), 100);
    }

    @Test
    public void doesNotJumpOnCarry0() {
        Register counter = new Register(96);
        new JLE(
            counter,
            new Register(6),
            new Register(84),
            new Register(0),
            new Register(1)
        ).execute();
        assertEquals(counter.toInt(), 100);
    }
}