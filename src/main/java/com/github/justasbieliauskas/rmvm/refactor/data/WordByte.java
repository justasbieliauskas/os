package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Nth byte of word.
 *
 * @author Justas Bieliauskas
 */
public class WordByte implements Byte
{
    private final Word word;

    private final Index index;

    /**
     * @param word word
     * @param index index of byte
     */
    public WordByte(Word word, int index) {
        this.word = word;
        this.index = () -> index;
    }

    @Override
    public byte toByte() {
        return (byte) (this.word.toInt() >> (8 * this.index.toInt()));
    }
}
