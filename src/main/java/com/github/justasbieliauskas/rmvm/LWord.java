package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to hold a word value and be evaluated to one.
 * E.g. register, 4 bytes in memory, etc.
 *
 * Can appear on both left and right sides of word assignment.
 *
 * @author Justas Bieliauskas
 */
public interface LWord extends RWord
{
    /**
     * Save integer value.
     *
     * @param value integer value
     */
    void assign(int value);
}
