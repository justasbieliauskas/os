package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MemoryOfStrings}.
 *
 * FIXME: oop tests
 *
 * @author Justas Bieliauskas
 */
public class MemoryOfStringsTest
{
    @Test
    public void extractsByte() {
        assertEquals(
            (byte) 114,
            new MemoryOfStrings("my", "string").byteAt(4)
        );
    }

    @Test
    public void modifiesByte() {
        MemoryOfStrings memory = new MemoryOfStrings("a", "bcd");
        memory.write((byte) 67, 2);
        assertEquals((byte) 97, memory.byteAt(0));
        assertEquals((byte) 98, memory.byteAt(1));
        assertEquals((byte) 67, memory.byteAt(2));
        assertEquals((byte) 100, memory.byteAt(3));
    }
}