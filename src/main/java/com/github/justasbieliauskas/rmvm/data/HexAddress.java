package com.github.justasbieliauskas.rmvm.data;

/**
 * Address as 2 hexadecimal symbols.
 *
 * @author Justas Bieliauskas
 */
public class HexAddress implements RWord
{
    private final char page;

    private final char cell;

    /**
     * @param page memory page index
     * @param cell cell index in that page
     */
    public HexAddress(char page, char cell) {
        this.page = page;
        this.cell = cell;
    }

    @Override
    public int toInt() {
        return Integer.parseInt("" + this.page + this.cell, 16);
    }
}
