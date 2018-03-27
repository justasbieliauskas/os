package com.github.justasbieliauskas.rmvm.data;

/**
 * Entity able to hold a value and be evaluated to one.
 * Can appear on both left and right sides of byte assignment.
 * E.g. register, least significant byte in register, etc.
 *
 * @author Justas Bieliauskas
 */
public interface LValue<T> extends RValue<T>
{

    /**
     * Store value.
     *
     * @param value value to store
     */
    void assign(T value);
}
