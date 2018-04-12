package com.github.justasbieliauskas.rmvm.refactor.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link WordByte}.
 *
 * @author Justas Bieliauskas
 */
public class WordByteTest
{
    @Test
    public void extractsByte() {
        assertEquals(new WordByte(() -> 13824, 1).toByte(), (byte) 54);
    }
}