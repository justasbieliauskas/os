package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;

/**
 * Register that does nothing on change.
 *
 * @author Justas Bieliauskas
 */
public class IgnoringRegister implements Register
{
    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public void change(int value) {

    }
}
