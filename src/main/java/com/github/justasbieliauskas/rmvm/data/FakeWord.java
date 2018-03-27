package com.github.justasbieliauskas.rmvm.data;

/**
 * Mock Word used for unit testing.
 *
 * FIXME: do we need this, if we can use lambdas?
 * FIXME: do we need this, if we have {@link Register} that does the same?
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
