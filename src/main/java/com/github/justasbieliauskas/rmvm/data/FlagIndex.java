package com.github.justasbieliauskas.rmvm.data;

/**
 * Index for status flag identified by symbol.
 * Symbol is one of 'Z' (zero), 'C' (carry), 'O' (overflow) or 'D' (direction).
 *
 * @author Justas Bieliauskas
 */
public class FlagIndex implements Scalar
{
    private final SymbolIndex index;

    /**
     * @param id index identifier as char
     */
    public FlagIndex(char id) {
        this.index = new SymbolIndex(id, 'Z', 'C', 'O', 'D');
    }

    @Override
    public int toInt() {
        return this.index.toInt();
    }
}
