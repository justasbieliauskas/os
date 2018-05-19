package com.github.justasbieliauskas.rmvm.data;

/**
 * Max word value.
 * Depends on number of bytes in word.
 *
 * @author Justas Bieliauskas
 */
public class MaxWord implements Word
{
    private final Scalar bytes;

    public MaxWord(Scalar bytes) {
        this.bytes = bytes;
    }

    @Override
    public long toLong() {
        return ((long) 1 << 8 * this.bytes.toInt()) - 1;
    }
}
