package com.github.justasbieliauskas.rmvm.refactor.data;

import java.util.Arrays;

/**
 * Index for status flag identified by symbol.
 * Symbol is one of 'Z' (zero), 'C' (carry), 'O' (overflow) or 'D' (direction).
 *
 * @author Justas Bieliauskas
 */
public class FlagIndex implements Index
{
    private final char id;

    /**
     * @param id index identifier as char
     */
    public FlagIndex(char id) {
        this.id = id;
    }

    @Override
    public int toInt() {
        return Arrays.asList('Z', 'C', 'O', 'D').indexOf(this.id);
    }
}
