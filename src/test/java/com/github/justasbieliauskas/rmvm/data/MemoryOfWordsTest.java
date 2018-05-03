package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MemoryOfWords}.
 *
 * TODO: oop tests
 *
 * @author Justas Bieliauskas
 */
public class MemoryOfWordsTest
{
    @Test
    public void extractsByte() {
        assertEquals(
            2,
            new MemoryOfWords(77, 566).byteAt(5)
        );
    }

    @Test
    public void modifiesByte() {
        MemoryOfWords memory = new MemoryOfWords(4, 130, 8903);
        memory.write((byte) 53, 9);
        assertEquals((byte) 199, memory.byteAt(8));
        assertEquals((byte) 53, memory.byteAt(9));
        assertEquals(0, memory.byteAt(10));
        assertEquals(0, memory.byteAt(11));
    }
}