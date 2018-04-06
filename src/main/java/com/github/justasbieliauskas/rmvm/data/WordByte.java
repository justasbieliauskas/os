package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;

/**
 * Nth byte in a word.
 * Can be assigned a byte value and modify original word.
 *
 * @author Justas Bieliauskas
 */
public class WordByte implements LByte
{
    private final LWord word;

    private final int index;

    /**
     * @param word word
     * @param index nth byte inside word
     */
    public WordByte(LWord word, int index) {
        this.word = word;
        this.index = index;
    }

    @Override
    public byte toByte() {
        return (byte) (this.word.toInt() >> (8 * this.index));
    }

    @Override
    public void assign(byte value) {
        byte[] bytes = ByteBuffer
            .allocate(Integer.BYTES)
            .putInt(this.word.toInt())
            .array();
        bytes[Integer.BYTES - this.index - 1] = value;
        this.word.assign(ByteBuffer.wrap(bytes).getInt());
    }
}
