package com.github.justasbieliauskas.rmvm.data;

import java.util.Iterator;

/**
 * Bytes with extra padding.
 * Used in converting bytes to word.
 *
 * @author Justas Bieliauskas
 */
public class PaddedBytes implements Iterable<java.lang.Byte>
{
    private final Iterable<java.lang.Byte> bytes;

    private final Scalar limit;

    /**
     * @param bytes bytes to pad
     * @param limit total number of bytes in resulting sequence
     */
    public PaddedBytes(Iterable<java.lang.Byte> bytes, Scalar limit) {
        this.bytes = bytes;
        this.limit = limit;
    }

    @Override
    public Iterator<java.lang.Byte> iterator() {
        Iterator<java.lang.Byte> iterator = this.bytes.iterator();
        int limit = this.limit.toInt();
        return new Iterator<java.lang.Byte>() {
            private int iteration = 0;

            @Override
            public boolean hasNext() {
                return this.iteration != limit;
            }

            @Override
            public java.lang.Byte next() {
                java.lang.Byte result = iterator.hasNext() ? iterator.next() : 0;
                this.iteration++;
                return result;
            }
        };
    }
}
