package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;

/**
 * Simple integer register.
 *
 * @author Justas Bieliauskas
 */
public class DefaultRegister implements Register
{
    private int word;

    /**
     * Sets default value as 0.
     */
    public DefaultRegister() {
        this(0);
    }

    /**
     * @param value default register value
     */
    public DefaultRegister(int value) {
        this.word = value;
    }

    @Override
    public int toInt() {
        return this.word;
    }

    @Override
    public void change(int value) {
        this.word = value;
    }
}
