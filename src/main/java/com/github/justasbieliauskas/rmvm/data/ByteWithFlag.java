package com.github.justasbieliauskas.rmvm.data;

/**
 * Byte with modified flag.
 *
 * @author Justas Bieliauskas
 */
public class ByteWithFlag implements Byte
{
    private final Byte original;

    private final Index index;

    private final Condition to1;

    /**
     * Constructor for testing.
     *
     * @param original original byte
     * @param index flag index
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    ByteWithFlag(byte original, int index, boolean to1) {
        this(() -> original, () -> index, () -> to1);
    }

    /**
     * Default constructor.
     *
     * @param original original byte to modify
     * @param index byte index in original word
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public ByteWithFlag(Byte original, Index index, Condition to1) {
        this.original = original;
        this.index = index;
        this.to1 = to1;
    }

    @Override
    public byte toByte() {
        byte filter = (byte) (1 << this.index.toInt());
        if(to1.isTrue()) {
            return (byte) (this.original.toByte() | filter);
        }
        return (byte) (this.original.toByte() & ~filter);
    }
}
