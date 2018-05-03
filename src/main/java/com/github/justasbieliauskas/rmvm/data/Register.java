package com.github.justasbieliauskas.rmvm.data;

/**
 * Register.
 *
 * @author Justas Bieliauskas
 */
public interface Register extends Word
{
    /**
     * Update state.
     *
     * @param value new value
     */
    void change(long value);
}
