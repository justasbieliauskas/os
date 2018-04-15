package com.github.justasbieliauskas.rmvm.data;

/**
 * Memory.
 *
 * @author Justas Bieliauskas
 */
public interface Memory
{
    /**
     * Modify byte in memory.
     *
     * @param index offset into memory
     * @param value new byte value
     */
    void write(int index, byte value);

    /**
     * Byte value at specific index.
     *
     * @param index offset into memory
     * @return byte value
     */
    byte byteAt(int index);
}
