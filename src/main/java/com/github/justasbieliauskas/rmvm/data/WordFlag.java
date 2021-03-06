package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.cpu.CPU;

/**
 * Bit (flag) of word.
 *
 * @author Justas Bieliauskas
 */
public class WordFlag implements Condition
{
    private final Byte wordByte;

    private final Scalar flagIndex;

    public WordFlag(Word word, Scalar bytes) {
        this(word, () -> bytes.toInt() - 1, () -> 7);
    }

    public WordFlag(CPU processor, char id) {
        this(new CPURegister(processor, "ST"), 0, new FlagIndex(id));
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

    private WordFlag(Word word, int byteIndex, Scalar flagIndex) {
        this(word, () -> byteIndex, flagIndex);
    }

    private WordFlag(Word word, Scalar byteIndex, Scalar flagIndex) {
        this.wordByte = new WordByte(word, byteIndex);
        this.flagIndex = flagIndex;
    }

    @Override
    public boolean isTrue() {
        return ((this.wordByte.toByte() >> this.flagIndex.toInt()) & 1) == 1;
    }
}
