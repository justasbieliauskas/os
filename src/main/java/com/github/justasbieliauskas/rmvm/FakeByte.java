package com.github.justasbieliauskas.rmvm;

/**
 * Mutable byte wrapper for unit testing.
 *
 * @author Justas Bieliauskas
 */
public class FakeByte implements Byte, ByteStorage
{
    private byte value;

    public FakeByte() {
        this((byte) 0);
    }

    public FakeByte(byte value) {
        this.value = value;
    }

    @Override
    public byte value() {
        return this.value;
    }

    @Override
    public void assign(byte value) {
        this.value = value;
    }
}
