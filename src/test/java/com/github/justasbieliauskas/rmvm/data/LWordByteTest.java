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
    public void extractsLeastSignificantByte() throws Exception {
        assertEquals(
            new LWordByte(new FakeWord(241), 0).value(),
            new Byte((byte) -15)
        );
    }

    @Test
    public void extractsMostSignificantByte() throws Exception {
        assertEquals(
            new LWordByte(
                new FakeWord(Integer.MAX_VALUE),
                Integer.BYTES - 1
            ).value(),
            new Byte((byte) 127)
        );
    }

    @Test
    public void changesLeastSignificantByte() throws Exception {
        FakeWord word = new FakeWord(-1);
        new LWordByte(word, 0).assign((byte) 50);
        assertEquals(word.value(), new Integer(-206));
    }

    @Test
    public void changesMostSignificantByte() throws Exception {
        FakeWord word = new FakeWord(-1);
        new LWordByte(word, Integer.BYTES - 1).assign((byte) 50);
        assertEquals(word.value(), new Integer(855638015));
    }
}