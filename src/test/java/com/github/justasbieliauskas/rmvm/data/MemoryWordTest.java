package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MemoryWord}.
 *
 * @author Justas Bieliauskas
 */
public class MemoryWordTest
{
    @Test
    public void extractsWord() {
        assertEquals(
            new MemoryWord(
                new byte[]{ 0, 100, 38, 0, 0, 20, 0, 84, 0, 100, 38, 0 },
                () -> 4
            ).toInt(),
            1310804
        );
    }
}