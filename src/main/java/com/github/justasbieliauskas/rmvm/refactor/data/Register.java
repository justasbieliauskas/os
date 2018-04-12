package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Register.
 *
 * @author Justas Bieliauskas
 */
public interface Register extends Word
{
    /**
     * Mutate register value.
     *
     * @param value new value
     */
    void change(int value);
}
