package com.github.justasbieliauskas.rmvm.data;

import java.util.Iterator;

/**
 * Bytes in memory.
 *
 * @author Justas Bieliauskas
 */
public class MemoryBytes implements Iterable<java.lang.Byte>
{
    private final MemoryByte memoryByte;

    private final Scalar offset;

    private final Scalar count;

    /**
     * @param memoryByte byte in memory that will be used to create new bytes
     * @param offset starting position of bytes
     * @param count how many bytes
     */
    public MemoryBytes(MemoryByte memoryByte, Scalar offset, Scalar count) {
        this.memoryByte = memoryByte;
        this.offset = offset;
        this.count = count;
    }

    @Override
    public Iterator<java.lang.Byte> iterator() {
        int offset = this.offset.toInt();
        int count = this.count.toInt();
        return new Iterator<java.lang.Byte>() {
            private int iterations = 0;

            @Override
            public boolean hasNext() {
                return (this.iterations + offset) < count;
            }

            @Override
            public java.lang.Byte next() {
                return MemoryBytes.this.memoryByte.at(
                    this.iterations++
                ).toByte();
            }
        };
    }
}
