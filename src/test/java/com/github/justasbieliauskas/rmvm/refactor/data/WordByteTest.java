package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.ByteEquality;
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
            new WordByte(() -> 13824, 1),
            (byte) 54
        ).test();
    }
}