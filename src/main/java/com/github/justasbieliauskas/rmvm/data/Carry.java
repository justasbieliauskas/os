package com.github.justasbieliauskas.rmvm.data;

/**
 * Carry flag (CF).
 *
 * @author Justas Bieliauskas
 */
public class Carry implements Flag
{
    private final StatusFlag flag;

    /**
     * @param status status register
     */
    public Carry(Register status) {
        this.flag = new StatusFlag(status, 1);
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
