package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to hold a byte value and be evaluated to one.
 * E.g. byte in memory, least significant byte in register, etc.
 *
 * Can appear on both left and right sides of byte assignment.
 *
 * @author Justas Bieliauskas
 */
public interface LByte extends RByte
{
    /**
     * Save byte value.
     *
     * @param value byte value
     */
    void assign(byte value);
}
