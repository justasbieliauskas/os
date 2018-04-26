package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Word;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that a {@link Word} equals integer.
 *
 * @author Justas Bieliauskas
 */
public class WordEquality implements Test
{
    private final Word value;

    private final Word expected;

    /**
     * Constructor for expecting value as integer.
     *
     * @param value word subject
     * @param expected expected value as long
     */
    public WordEquality(Word value, long expected) {
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
        assertEquals(this.value.toLong(), this.expected.toLong());
    }
}
