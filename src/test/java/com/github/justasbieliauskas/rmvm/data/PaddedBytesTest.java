package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.SequenceAsArray;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test for {@link PaddedBytes}.
 *
 * @author Justas Bieliauskas
 */
public class PaddedBytesTest
{
    @Test
    public void padsBytes() {
        Iterator<java.lang.Byte> bytes = new PaddedBytes(
            new SequenceAsArray<>((byte) 15),
            () -> 2
        ).iterator();
        assertEquals(new java.lang.Byte((byte) 15), bytes.next());
        assertEquals(new java.lang.Byte((byte) 0), bytes.next());
        assertFalse(bytes.hasNext());
    }
}