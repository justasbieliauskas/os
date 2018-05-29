package com.github.justasbieliauskas.rmvm.data;

/**
 * Byte in memory as array of bytes.
 *
 * @author Justas Bieliauskas
 */
public class ArrayMemoryByte implements MemoryByte
{
    private final byte[] bytes;

    private final int index;

    /**
     * @param bytes memory
     * @param index position of this byte
     */
    public ArrayMemoryByte(byte[] bytes, int index) {
        this.bytes = bytes;
        this.index = index;
    }

    @Override
    public byte toByte() {
        return this.bytes[this.index];
    }

    @Override
    public void change(byte value) {
        this.bytes[this.index] = value;
    }

    @Override
    public MemoryByte at(int index) {
        return new ArrayMemoryByte(this.bytes, index);
    }
}
