package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;

/**
 * Specific byte in a word.
 *
 * @author Justas Bieliauskas
 */
public class LWordByte implements LByte
{
    private final LWord word;

    private final int which;

    /**
     * @param word word
     * @param index index of byte in word
     */
    public LWordByte(LWord word, int index) {
        this.word = word;
        this.which = index;
    }

    @Override
    public byte value() {
        return (byte) (this.word.value() >>> (8 * this.which));
    }

    @Override
    public void assign(byte value) {
        byte[] bytes = ByteBuffer
            .allocate(Integer.BYTES)
            .putInt(this.word.value())
            .array();
        bytes[Integer.BYTES - this.which - 1] = value;
        this.word.assign(ByteBuffer.wrap(bytes).getInt());
    }
}
