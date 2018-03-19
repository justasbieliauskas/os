package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to be evaluated to byte value.
 * E.g. least significant byte in register, a sum of 2 bytes, etc.
 *
 * @author Justas Bieliauskas
 */
public interface Byte
{
    /**
     * @return byte representation
     */
    byte value();
}
