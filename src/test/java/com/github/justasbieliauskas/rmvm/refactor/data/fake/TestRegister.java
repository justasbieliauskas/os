package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.CloneableTest;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;

/**
 * Register with ability to test incoming value on change.
 *
 * @author Justas Bieliauskas
 */
public class TestRegister implements Register
{
    private final CloneableTest test;

    /**
     * @param test test that can clone itself with new value
     */
    public TestRegister(CloneableTest test) {
        this.test = test;
    }

    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public void change(int value) {
        this.test.with(value).test();
    }
}
