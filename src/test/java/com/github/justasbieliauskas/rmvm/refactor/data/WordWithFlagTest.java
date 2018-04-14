package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import org.junit.Test;

/**
 * Test for {@link WordWithFlag}.
 *
 * @author Justas Bieliauskas
 */
public class WordWithFlagTest
{
    @Test
    public void changesSeveralFlags() {
        new WordEquality(
            new WordWithFlag(
                new WordWithFlag(() -> 690699360, 0, 3, true),
                3,
                5,
                false
            ),
            153828456
        ).test();
    }
}