package com.github.justasbieliauskas.rmvm.data;

/**
 * Nth byte in {@link RWord}.
 *
 * @author Justas Bieliauskas
 */
public class RWordByte implements RByte
{
    private final RWord word;

    private final int index;

    /**
     * @param word word
     * @param index byte index
     */
    public RWordByte(RWord word, int index) {
        this.word = word;
        this.index = index;
    }

    @Override
    public byte toByte() {
        return (byte) (this.word.toInt() >>> (8 * this.index));
    }
}
