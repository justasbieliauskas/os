package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import org.junit.Test;

/**
 * Test for {@link NthWord}.
 *
 * @author Justas Bieliauskas
 */
public class NthWordTest
{
    @Test
    public void picksNthWord() {
        new WordEquality(
            new NthWord(
                new Word[] {
                    () -> 1,
                    () -> 2,
                    () -> 3
                },
                1
            ),
            2
        ).test();
    }
}