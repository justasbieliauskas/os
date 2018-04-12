package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Byte with modified nth flag.
 * For possible flag identifiers {@link FlagIndex}.
 *
 * @author Justas Bieliauskas
 */
public class ModifiedByte implements Byte
{
    private final Byte original;

    private final Index index;

    private final Condition to1;

    /**
     * @param original original byte
     * @param index flag index
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public ModifiedByte(Byte original, Index index, Condition to1) {
        this.original = original;
        this.index = index;
        this.to1 = to1;
    }

    @Override
    public byte toByte() {
        byte filter = (byte) (1 << this.index.toInt());
        if(this.to1.isTrue()) {
            return (byte) (this.original.toByte() | filter);
        }
        return (byte) (this.original.toByte() & ~filter);
    }
}
