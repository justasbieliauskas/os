package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link LWordByte}
 *
 * @author Justas Bieliauskas
 */
public class LWordByteTest
{
    @Test
    public void changesLeastSignificantByte() throws Exception {
        FakeWord word = new FakeWord(-1);
        new LWordByte(word, 0).assign((byte) 50);
        assertEquals(word.value(), -206);
    }

    @Test
    public void changesMostSignificantByte() throws Exception {
        FakeWord word = new FakeWord(-1);
        new LWordByte(word, Integer.BYTES - 1).assign((byte) 50);
        assertEquals(word.value(), 855638015);
    }
}