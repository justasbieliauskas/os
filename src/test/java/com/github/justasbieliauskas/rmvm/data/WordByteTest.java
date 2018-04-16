package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.ByteEquality;
import org.junit.Test;

/**
 * Test for {@link WordByte}.
 *
 * @author Justas Bieliauskas
 */
public class WordByteTest
{
    @Test
    public void extractsByte() {
        new ByteEquality(
            new WordByte(13824, 1),
            54
        ).test();
    }
}