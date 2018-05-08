package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Scalar;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that an {@link Scalar} equals integer.
 *
 * @author Justas Bieliauskas
 */
public class IndexEquality implements Test
{
    private final Scalar index;

    private final int value;

    /**
     * @param index subject index
     * @param value expected value
     */
    public IndexEquality(Scalar index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public void test() {
        assertEquals(this.index.toInt(), this.value);
    }
}
