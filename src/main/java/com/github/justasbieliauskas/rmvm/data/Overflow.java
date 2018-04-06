package com.github.justasbieliauskas.rmvm.data;

/**
 * Overflow flag (OF).
 *
 * @author Justas Bieliauskas
 */
public class Overflow implements Flag
{
    private final StatusFlag flag;

    /**
     * @param status status register
     */
    public Overflow(Register status) {
        this.flag = new StatusFlag(status, 0, 2);
    }

    @Override
    public void assign(boolean to1) {
        this.flag.assign(to1);
    }

    @Override
    public boolean isTrue() {
        return this.flag.isTrue();
    }
}
