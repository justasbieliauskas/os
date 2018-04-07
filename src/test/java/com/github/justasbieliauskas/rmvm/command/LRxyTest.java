package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link LRxy}.
 *
 * @author Justas Bieliauskas
 */
public class LRxyTest
{
    @Test
    public void loadsWordToA() {
        Register a = new Register(5);
        byte[] memory = new byte[] {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 76, 0, 0, 51, 0, 0, 0, 0
        };
        new LRxy(a, memory, '1', '8').execute();
        assertEquals(a.toInt(), 1275068467);
    }
}