package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;

import static org.junit.Assert.assertTrue;

/**
 * Register whose value can't be changed.
 * Used in tests.
 *
 * @author Justas Bieliauskas
 */
public class UnchangeableRegister implements Register
{
    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public void change(int value) {
        // FIXME: better assertion for a method that cannot be called.
        assertTrue(false);
    }
}
