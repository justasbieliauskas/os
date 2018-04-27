package com.github.justasbieliauskas.rmvm.data;

/**
 * Max word value with another word added to it.
 *
 * @author Justas Bieliauskas
 */
public class MaxWord implements Word
{
    private final int number;

    /**
     * Constructor for max word value with no addition.
     */
    public MaxWord() {
        this(0);
    }

    /**
     * Default constructor.
     *
     * @param number number to add to max word
     */
    public MaxWord(int number) {
        this.number = number;
    }

    @Override
    public long toLong() {
        return 4294967295L + this.number;
    }
}
