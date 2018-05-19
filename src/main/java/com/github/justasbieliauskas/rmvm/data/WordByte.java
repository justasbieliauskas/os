package com.github.justasbieliauskas.rmvm.data;

/**
 * Nth byte in word.
 *
 * @author Justas Bieliauskas
 */
public class WordByte implements Byte
{
    private final Word word;

    private final Scalar index;

    /**
     * Constructor for testing.
     *
     * @param word word as integer
     * @param index byte integer
     */
    WordByte(int word, int index) {
        this(() -> word, index);
    }

    WordByte(Word word, int index) {
        this(word, () -> index);
    }

    public WordByte(Word word, Scalar index) {
        this.word = word;
        this.index = index;
    }

    @Override
    public byte toByte() {
        return (byte) (this.word.toLong() >> (8 * this.index.toInt()));
    }
}
