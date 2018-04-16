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
        this.wordByte = () -> (byte) (word.toInt() >> (8 * byteIndex));
        this.flagIndex = flagIndex;
    }

    @Override
    public boolean isTrue() {
        return ((this.wordByte.toByte() >> this.flagIndex.toInt()) & 1) == 1;
    }
}
