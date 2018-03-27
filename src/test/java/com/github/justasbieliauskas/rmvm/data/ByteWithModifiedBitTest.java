package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link ByteWithModifiedBit}
 *
 * @author Justas Bieliauskas
 */
public class ByteWithModifiedBitTest
{
    @Test
    public void changesByteTo1() throws Exception {
        assertEquals(
            new ByteWithModifiedBit(() -> (byte) 113, 2, () -> true).toByte(),
            (byte) 117
        );
    }

    @Test
    public void changesByteTo0() throws Exception {
        assertEquals(
            new ByteWithModifiedBit(() -> (byte) 107, 3, () -> false).toByte(),
            (byte) 99
        );
    }
}