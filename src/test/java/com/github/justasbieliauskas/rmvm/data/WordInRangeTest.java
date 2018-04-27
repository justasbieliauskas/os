package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.WordEquality;
import org.junit.Test;

/**
 * Test for {@link WordInRange}.
 *
 * @author Justas Bieliauskas
 */
public class WordInRangeTest
{
    @Test
    public void doesNotFlipWord() {
        new WordEquality(
            new WordInRange(123, 500),
            123
        ).test();
    }

    @Test
    public void flipsWord() {
        new WordEquality(
            new WordInRange(444, 443),
            0
        ).test();
    }
}