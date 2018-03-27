package com.github.justasbieliauskas.rmvm.data;

/**
 * Mock Word used for unit testing.
 *
 * @author Justas Bieliauskas
 */
public class FakeWord implements LWord
{
    private int word;

    public FakeWord() {
        this(0);
    }

    public FakeWord(int word) {
        this.word = word;
    }

    @Override
    public int toInt() {
        return this.word;
    }

    @Override
    public void assign(int value) {
        this.word = value;
    }
}
