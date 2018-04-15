package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Word;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that a {@link Word} equals integer.
 *
 * @author Justas Bieliauskas
 */
public class WordEquality implements CloneableTest
{
    private final Word value;

    private final Word expected;

    /**
     * Constructor for when test is only going to clone itself.
     * In that case, word value is irrelevant.
     *
     * @param expected expected value as integer
     */
    public WordEquality(int expected) {
        this(() -> 0, expected);
    }

    /**
     * Constructor for expecting value as integer.
     *
     * @param value word subject
     * @param expected expected value as integer
     */
    public WordEquality(Word value, int expected) {
        this(value, () -> expected);
    }

    /**
     * Default constructor.
     *
     * @param value word subject
     * @param expected expected value
     */
    public WordEquality(Word value, Word expected) {
        this.value = value;
        this.expected = expected;
    }

    @Override
    public void test() {
        assertEquals(this.value.toInt(), this.expected.toInt());
    }

    @Override
    public CloneableTest with(int value) {
        return new WordEquality(() -> value, this.expected);
    }
}
