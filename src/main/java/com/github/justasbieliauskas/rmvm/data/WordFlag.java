package com.github.justasbieliauskas.rmvm.data;

/**
 * Bit (flag) of word.
 *
 * @author Justas Bieliauskas
 */
public class WordFlag implements Condition
{
    private final Byte wordByte;

    private final Index flagIndex;

    /**
     * Constructor for creating status flag by its identifier.
     *
     * @param status status register
     * @param id flag identifier
     */
    public WordFlag(Word status, char id) {
        this(status, 0, new FlagIndex(id));
    }

    /**
     * Constructor for creating most/least significant bit.
     *
     * @param word word
     * @param byteIndex byte index in word
     * @param flagIndex flag index in byte as integer
     */
    public WordFlag(Word word, int byteIndex, int flagIndex) {
        this(word, byteIndex, () -> flagIndex);
    }

    /**
     * Constructor for testing.
     *
     * @param word word as integer
     * @param byteIndex byte index in word as integer
     * @param flagIndex bit index in byte as integer
     */
    WordFlag(int word, int byteIndex, int flagIndex) {
        this(() -> word, byteIndex, () -> flagIndex);
    }

    private WordFlag(Word word, int byteIndex, Index flagIndex) {
        this.wordByte = new WordByte(word, byteIndex);
        this.flagIndex = flagIndex;
    }

    @Override
    public boolean isTrue() {
        return ((this.wordByte.toByte() >> this.flagIndex.toInt()) & 1) == 1;
    }
}
