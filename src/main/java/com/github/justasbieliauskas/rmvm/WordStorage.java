package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to hold a word value.
 * E.g. register, 4 bytes in memory, etc.
 *
 * @author Justas Bieliauskas
 */
public interface WordStorage
{
    /**
     * Save int value (4 bytes) to this storage.
     *
     * @param value integer number
     */
    void assign(int value);
}
