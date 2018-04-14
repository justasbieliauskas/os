package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;

/**
 * Simple integer register.
 *
 * @author Justas Bieliauskas
 */
public class FakeRegister implements Register
{
    private int word;

    /**
     * Sets default value as 0.
     */
    public FakeRegister() {
        this(0);
    }

    /**
     * @param value default register value
     */
    public FakeRegister(int value) {
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
