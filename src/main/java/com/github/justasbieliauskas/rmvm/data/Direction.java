package com.github.justasbieliauskas.rmvm.data;

/**
 * Direction flag (DF).
 *
 * @author Justas Bieliauskas
 */
public class Direction implements Flag
{
    private final StatusFlag flag;

    /**
     * @param status status register
     */
    public Direction(Register status) {
        this.flag = new StatusFlag(status, 3);
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
