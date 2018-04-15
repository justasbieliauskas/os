package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Nth word in array of words.
 *
 * @author Justas Bieliauskas
 */
public class NthWord implements Word
{
    private final Word[] words;

    private final Index index;

    /**
     * Constructor for testing.
     *
     * @param words words
     * @param index word index as integer
     */
    NthWord(Word[] words, int index) {
        this(words, () -> index);
    }

    /**
     * Default constructor.
     *
     * @param words words
     * @param index word index
     */
    public NthWord(Word[] words, Index index) {
        this.words = words;
        this.index = index;
    }

    @Override
    public int toInt() {
        return this.words[this.index.toInt()].toInt();
    }
}
