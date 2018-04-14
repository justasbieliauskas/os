package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Index;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that an {@link Index} equals integer.
 *
 * @author Justas Bieliauskas
 */
public class IndexEquality implements Test
{
    private final Index index;

    private final int value;

    /**
     * @param index subject index
     * @param value expected value
     */
    public IndexEquality(Index index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public void test() {
        assertEquals(this.index.toInt(), this.value);
    }
}
