package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Word;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that a {@link Word} equals integer.
 *
 * @author Justas Bieliauskas
 */
public class WordEquality implements Test
{
    private final Word word;

    private final int value;

    /**
     * @param word word subject
     * @param value expected value
     */
    public WordEquality(Word word, int value) {
        this.word = word;
        this.value = value;
    }

    @Override
    public void test() {
        assertEquals(this.word.toInt(), this.value);
    }
}
