package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;

/**
 * Memory consisting of words.
 *
 * FIXME: refactor duplicate code
 *
 * @author Justas Bieliauskas
 */
public class MemoryOfWords implements Memory
{
    private final long[] words;

    /**
     * @param words words
     */
    public MemoryOfWords(long... words) {
        this.words = words;
    }

    @Override
    public byte byteAt(int index) {
        return (byte) (this.words[index / 4] >> (8 * (index % 4)));
    }

    @Override
    public void write(byte value, int index) {
        byte[] bytes = ByteBuffer
            .allocate(Long.BYTES)
            .putLong(this.words[index / 4])
            .array();
        bytes[Long.BYTES - (index % 4) - 1] = value;
        this.words[index / 4] = ByteBuffer.wrap(bytes).getLong();
    }
}
