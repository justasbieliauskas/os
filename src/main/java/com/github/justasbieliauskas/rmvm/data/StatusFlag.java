package com.github.justasbieliauskas.rmvm.data;

/**
 * Generalized version of flag.
 * Represents any flag - direction, carry, etc.
 *
 * TODO: make one class for flags.
 *
 * @author Justas Bieliauskas
 */
public class StatusFlag implements Flag
{
    private final WordByte statusByte;

    private final int index;

    /**
     * @param status status register
     * @param byteIndex index of byte in status register
     * @param bitIndex index of bit in given byte
     */
    public StatusFlag(Register status, int byteIndex, int bitIndex) {
        this.statusByte = new WordByte(status, byteIndex);
        this.index = bitIndex;
    }

    @Override
    public void assign(boolean to1) {
        byte bit = (byte) (1 << this.index);
        byte result;
        if(to1) {
            result = (byte) (this.statusByte.toByte() | bit);
        } else {
            result = (byte) (this.statusByte.toByte() & ~bit);
        }
        this.statusByte.assign(result);
    }

    @Override
    public boolean isTrue() {
        return ((this.statusByte.toByte() >> this.index) & 1) == 1;
    }
}
