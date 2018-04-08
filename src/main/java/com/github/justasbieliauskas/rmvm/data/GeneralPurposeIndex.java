package com.github.justasbieliauskas.rmvm.data;

/**
 * Index for general purpose register in processor from symbol identifier.
 * Symbol is one of 'A', 'B', 'C', or 'D'.
 *
 * @author Justas Bieliauskas
 */
public class GeneralPurposeIndex implements RWord
{
    private final byte id;

    /**
     * @param id character representation of symbol
     */
    public GeneralPurposeIndex(char id) {
        this((byte) id);
    }

    /**
     * @param id byte value of symbol
     */
    public GeneralPurposeIndex(byte id) {
        this.id = id;
    }

    @Override
    public int toInt() {
        return this.id - 65;
    }
}
