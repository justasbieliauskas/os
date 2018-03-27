package com.github.justasbieliauskas.rmvm.data;

/**
 * Entity able to be evaluated to byte.
 * E.g. least significant byte in register, a sum of 2 bytes, etc.
 *
 * Appears on the right side of byte assignment.
 *
 * @author Justas Bieliauskas
 */
public interface RByte
{
    /**
     * @return byte representation
     */
    byte value();
}
