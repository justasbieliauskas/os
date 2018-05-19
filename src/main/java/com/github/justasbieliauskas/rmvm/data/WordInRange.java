package com.github.justasbieliauskas.rmvm.data;

/**
 * Word not exceeding word range.
 *
 * @author Justas Bieliauskas
 */
public class WordInRange implements Word
{
    private final Word word;

    private final Word max;

    /**
     * Constructor for testing.
     *
     * @param word checked word as long
     * @param max word limit as long
     */
    WordInRange(long word, long max) {
        this(() -> word, () -> max);
    }

    public WordInRange(Word word, Scalar bytes) {
        this(word, new MaxWord(bytes));
    }

    /**
     * Default constructor.
     *
     * @param word checked word
     * @param max word limit
     */
    public WordInRange(Word word, Word max) {
        this.word = word;
        this.max = max;
    }

    @Override
    public long toLong() {
        long word = this.word.toLong();
        long max = this.max.toLong();
        if(word > max) {
            word -= (max + 1);
        }
        return word;
    }
}
