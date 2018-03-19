package com.github.justasbieliauskas.rmvm;

/**
 * Mutable integer wrapper for unit testing.
 *
 * @author Justas Bieliauskas
 */
public class FakeWord implements Word, WordStorage
{
    private int value;

    public FakeWord() {
        this(0);
    }

    public FakeWord(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return this.value;
    }

    @Override
    public void assign(int value) {
        this.value = value;
    }
}
