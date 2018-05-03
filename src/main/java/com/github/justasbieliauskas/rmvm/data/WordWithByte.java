package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;

/**
 * Word with modified byte.
 *
 * @author Justas Bieliauskas
 */
public class WordWithByte implements Word
{
    private final Word original;

    private final int index;

    private final Byte modified;

    /**
     * Constructor for testing.
     *
     * @param original original word
     * @param index byte index
     * @param modified new byte
     */
    WordWithByte(long original, int index, byte modified) {
        this(() -> original, index, () -> modified);
    }

    /**
     * Default constructor.
     *
     * @param original original word to modify
     * @param index byte index in original word
     * @param modified modified byte to replace old byte
     */
    public WordWithByte(Word original, int index, Byte modified) {
        this.original = original;
        this.index = index;
        this.modified = modified;
    }

    @Override
    public long toLong() {
        byte[] bytes = ByteBuffer
            .allocate(Long.BYTES)
            .putLong(this.original.toLong())
            .array();
        bytes[Long.BYTES - this.index - 1] = this.modified.toByte();
        return ByteBuffer.wrap(bytes).getLong();
    }
}
