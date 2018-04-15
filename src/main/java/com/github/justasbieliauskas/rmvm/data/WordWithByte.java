package com.github.justasbieliauskas.rmvm.data;

import java.lang.*;
import java.nio.ByteBuffer;

/**
 * Word with modified nth byte.
 *
 * @author Justas Bieliauskas
 */
public class WordWithByte implements Word
{
    private final Word original;

    private final int index;

    private final Byte newByte;

    /**
     * @param original original word
     * @param index word byte index as integer
     * @param newByte new byte
     */
    public WordWithByte(Word original, int index, Byte newByte) {
        this.original = original;
        this.index = index;
        this.newByte = newByte;
    }

    @Override
    public int toInt() {
        byte[] bytes = ByteBuffer
            .allocate(Integer.BYTES)
            .putInt(this.original.toInt())
            .array();
        bytes[Integer.BYTES - this.index - 1] = this.newByte.toByte();
        return ByteBuffer.wrap(bytes).getInt();
    }
}
