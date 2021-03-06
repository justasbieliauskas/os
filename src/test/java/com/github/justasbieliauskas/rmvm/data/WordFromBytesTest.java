package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.WordEquality;
import org.junit.Test;

import java.lang.*;
import java.lang.Byte;

/**
 * Test for {@link WordFromBytes}.
 *
 * @author Justas Bieliauskas
 */
public class WordFromBytesTest
{
    @Test
    public void convertsToWord() {
        new WordEquality(
            new WordFromBytes(
                new WordBytes(() -> 45, () -> 4)
            ),
            45
        ).test();
    }
}