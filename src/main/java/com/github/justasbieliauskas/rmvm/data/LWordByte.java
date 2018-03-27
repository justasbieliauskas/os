package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;

/**
 * Nth byte in a word.
 * Can be assigned a byte value and modify original word.
 *
 * TODO: if we don't need {@link RWordByte}, clean this up.
 *
 * @author Justas Bieliauskas
 */
public class LWordByte implements LByte
{
    private final LWord word;

    private final int index;

    private final RWordByte rByte;

    /**
     * @param word word
     * @param index nth byte inside word
     */
    public LWordByte(LWord word, int index) {
        this.word = word;
        this.index = index;
        this.rByte = new RWordByte(word, index);
    }

    @Override
    public byte toByte() {
        return this.rByte.toByte();
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
