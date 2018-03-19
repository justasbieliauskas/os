package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to hold a byte value.
 * E.g. byte in memory, least significant byte in register, etc.
 *
 * @author Justas Bieliauskas
 */
public interface ByteStorage
{
    /**
     * Save byte value to this storage.
     *
     * @param value byte number
     */
    void assign(byte value);
}
