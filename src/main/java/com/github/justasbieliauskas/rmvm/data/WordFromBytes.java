package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/**
 * Word from sequence of bytes.
 * Given sequence must be little-endian.
 * It is then converted to big-endian and padded with zeroes, so that
 * the total number of bytes before conversion is equal to {@code Long.BYTES}.
 *
 * @author Justas Bieliauskas
 */
public class WordFromBytes implements Word
{
    private final Iterable<java.lang.Byte> bytes;

    /**
     * @param bytes sequence of bytes
     */
    public WordFromBytes(Iterable<java.lang.Byte> bytes) {
        this.bytes = bytes;
    }

    @Override
    public long toLong() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        Iterator<java.lang.Byte> iterator = this.bytes.iterator();
        java.lang.Byte put;
        for(int i = 0; i != Long.BYTES; i++) {
            put = iterator.hasNext() ? iterator.next() : 0;
            buffer.put(put);
        }
        buffer.flip();
        return buffer.getLong();
    }
}
