package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;

import static org.junit.Assert.assertEquals;

/**
 * Register asserting equality on change.
 *
 * @author Justas Bieliauskas
 */
public class EqualityRegister implements Register
{
    private final int value;

    /**
     * @param value expected value
     */
    public EqualityRegister(int value) {
        this.value = value;
    }

    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public void change(int value) {
        assertEquals(value, this.value);
    }
}
