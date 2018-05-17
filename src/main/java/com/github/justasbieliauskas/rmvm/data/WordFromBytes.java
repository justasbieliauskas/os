package com.github.justasbieliauskas.rmvm.data;

import java.lang.Byte;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Word from sequence of bytes.
 * Given byte sequence must have a length of {@code Long.BYTES}
 * and be big-endian, meaning, lsb should come last.
 *
 * @author Justas Bieliauskas
 */
public class WordFromBytes implements Word
{
    private final Iterable<java.lang.Byte> bytes;

    /**
     * Constructor for initializing with byte array and default size of 4.
     * Used in testing.
     *
     * @param bytes bytes
     */
    WordFromBytes(Byte[] bytes) {
        this(() -> Arrays.asList(bytes).iterator());
    }

    /**
     * Default constructor.
     *
     * @param bytes sequence of bytes
     */
    public WordFromBytes(Iterable<Byte> bytes) {
        this.bytes = bytes;
    }

    @Override
    public long toLong() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        for(byte b : this.bytes) {
            buffer.put(b);
        }
        buffer.flip();
        return buffer.getLong();
    }
}
