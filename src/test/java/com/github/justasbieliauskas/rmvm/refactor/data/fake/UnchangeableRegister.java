package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;

import static org.junit.Assert.fail;

/**
 * Register whose value can't be changed.
 * Used in tests.
 *
 * @author Justas Bieliauskas
 */
public class UnchangeableRegister implements Register
{
    private final String name;

    /**
     * @param name short register description
     */
    public UnchangeableRegister(String name) {
        this.name = name;
    }

    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public void change(int value) {
        fail("Should not change register \"" + this.name + "\".");
    }
}
