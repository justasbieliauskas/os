package com.github.justasbieliauskas.rmvm;

/**
 * A word with bits reversed.
 *
 * @author Justas Bieliauskas
 */
public class OnesCompliment implements Word
{
    private final Word word;

    public OnesCompliment(Word word) {
        this.word = word;
    }

    @Override
    public int value() {
        return ~ this.word.value();
    }
}
