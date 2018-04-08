package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link WordByte}
 *
 * @author Justas Bieliauskas
 */
public class WordByteTest
{
    @Test
    public void extractsLeastSignificantByte() throws Exception {
        assertEquals(
            new WordByte(new DefaultRegister(241), 0).toByte(),
            (byte) -15
        );
    }

    @Test
    public void extractsMostSignificantByte() throws Exception {
        assertEquals(
            new WordByte(
                new DefaultRegister(Integer.MAX_VALUE),
                Integer.BYTES - 1
            ).toByte(),
            (byte) 127
        );
    }
    
    @Test
    public void changesLeastSignificantByte() throws Exception {
        DefaultRegister word = new DefaultRegister(-1);
        new WordByte(word, 0).assign((byte) 50);
        assertEquals(word.toInt(), -206);
    }

    @Test
    public void changesMostSignificantByte() throws Exception {
        DefaultRegister word = new DefaultRegister(-1);
        new WordByte(word, Integer.BYTES - 1).assign((byte) 50);
        assertEquals(word.toInt(), 855638015);
    }
}