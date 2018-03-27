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

    private final int index;

    private final RWordByte rByte;

    public LWordByte(LWord word, int index) {
        this(word, index, new RWordByte(word, index));
    }

    public LWordByte(LWord word, int index, RWordByte rByte) {
        this.word = word;
        this.index = index;
        this.rByte = rByte;
    }

    @Override
    public byte value() {
        return this.rByte.value();
    }

    @Override
    public void assign(byte value) {
        byte[] bytes = ByteBuffer
            .allocate(Integer.BYTES)
            .putInt(this.word.value())
            .array();
        bytes[Integer.BYTES - this.index - 1] = value;
        this.word.assign(ByteBuffer.wrap(bytes).getInt());
    }
}
