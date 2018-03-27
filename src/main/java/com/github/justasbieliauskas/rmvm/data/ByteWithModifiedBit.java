package com.github.justasbieliauskas.rmvm.data;

/**
 * Byte whose bit is modified.
 *
 * @author Justas Bieliauskas
 */
public class ByteWithModifiedBit implements RByte
{
    private final RByte original;

    private final int index;

    private final Condition to1;

    /**
     * @param original unmodified byte
     * @param index bit index in byte
     * @param to1 should bit be changed to 1 (true) or 0 (false)
     */
    public ByteWithModifiedBit(RByte original, int index, Condition to1) {
        this.original = original;
        this.index = index;
        this.to1 = to1;
    }

    @Override
    public byte toByte() {
        byte bit = (byte) (1 << this.index);
        if(this.to1.isTrue()) {
            return (byte) (this.original.toByte() | bit);
        }
        return (byte) (this.original.toByte() & ~bit);
    }
}
