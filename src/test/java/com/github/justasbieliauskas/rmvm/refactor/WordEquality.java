package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Word;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that a {@link Word} equals integer.
 *
 * @author Justas Bieliauskas
 */
public class WordEquality implements CloneableTest
{
    private final Word word;

    private final int value;

    /**
     * Constructor for when test is only going to clone itself.
     * In that case, word value is irrelevant.
     *
     * @param value expected value
     */
    public WordEquality(int value) {
        this(0, value);
    }

    private WordEquality(int word, int value) {
        this(() -> word, value);
    }

    /**
     * Default constructor.
     *
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

    @Override
    public CloneableTest with(int value) {
        return new WordEquality(value, this.value);
    }
}
