package com.github.justasbieliauskas.rmvm.data;

/**
 * Entity able to be evaluated to a value.
 * Appears on the right side of byte assignment.
 * E.g. byte in memory, a sum of 2 bytes, etc.
 *
 * @author Justas Bieliauskas
 */
public interface RValue<T>
{
    /**
     * Evaluate.
     *
     * @return T representation
     */
    T value();
}
