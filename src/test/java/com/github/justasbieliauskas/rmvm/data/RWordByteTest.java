package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link RWordByte}.
 *
 * @author Justas Bieliauskas
 */
public class RWordByteTest
{
    @Test
    public void extractsLeastSignificantByte() throws Exception {
        assertEquals(
            new RWordByte(new FakeWord(241), 0).value(),
            (byte) -15
        );
    }

    @Test
    public void extractsMostSignificantByte() throws Exception {
        assertEquals(
            new RWordByte(
                new FakeWord(Integer.MAX_VALUE),
                Integer.BYTES - 1
            ).value(),
            (byte) 127
        );
    }
}