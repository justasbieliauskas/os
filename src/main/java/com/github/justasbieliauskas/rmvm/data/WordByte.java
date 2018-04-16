package com.github.justasbieliauskas.rmvm.data;

/**
 * Nth byte in word.
 *
 * @author Justas Bieliauskas
 */
public class WordByte implements Byte
{
    private final Word word;

    private final int index;

    /**
     * Constructor for testing.
     *
     * @param word word as integer
     * @param index byte integer
     */
    WordByte(int word, int index) {
        this(() -> word, index);
    }

    /**
     * Default constructor.
     *
     * @param word word
     * @param index byte index
     */
    public WordByte(Word word, int index) {
        this.word = word;
        this.index = index;
    }

    @Override
    public byte toByte() {
        return (byte) (this.word.toInt() >> (8 * this.index));
    }
}
