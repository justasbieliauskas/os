package com.github.justasbieliauskas.rmvm;

/**
 * Register - general purpose, instruction counter, etc.
 * A register is 4 bytes long.
 *
 * @author Justas Bieliauskas
 */
public class Register implements WordStorage, Word
{
    private int value = 0;

    @Override
    public void assign(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return this.value;
    }
}
