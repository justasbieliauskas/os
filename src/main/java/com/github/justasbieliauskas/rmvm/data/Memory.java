package com.github.justasbieliauskas.rmvm.data;

/**
 * User memory.
 *
 * @author Justas Bieliauskas
 */
public interface Memory
{
    /**
     * Fetches a byte at given index.
     *
     * @param index byte index
     * @return byte value
     */
    byte byteAt(int index);

    /**
     * Write byte to memory at given index.
     *
     * @param value byte value
     * @param index index to write to
     */
    void write(byte value, int index);
}
