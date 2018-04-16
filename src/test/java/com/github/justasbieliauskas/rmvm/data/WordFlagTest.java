package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.Truthfulness;
import org.junit.Test;

/**
 * Test for {@link WordFlag}.
 *
 * @author Justas Bieliauskas
 */
public class WordFlagTest
{
    @Test
    public void extractsFlag() {
        new Truthfulness(
            new WordFlag(2, 0, 1)
        ).test();
    }
}