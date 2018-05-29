package com.github.justasbieliauskas.rmvm.data;

/**
 * Single byte in memory.
 *
 * @author Justas Bieliauskas
 */
public interface MemoryByte extends Byte
{
    /**
     * Modify this byte.
     *
     * @param value new value
     */
    void change(byte value);

    /**
     * Create new byte in memory at given position.
     *
     * @param index position of new byte
     * @return new byte in memory
     */
    MemoryByte at(int index);
}
