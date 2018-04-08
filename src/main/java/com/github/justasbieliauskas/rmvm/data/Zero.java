package com.github.justasbieliauskas.rmvm.data;

/**
 * Zero flag (ZF).
 *
 * @author Justas Bieliauskas
 */
public class Zero implements Flag
{
    private final StatusFlag flag;

    /**
     * @param status status register
     */
    public Zero(DefaultRegister status) {
        this.flag = new StatusFlag(status, 0, 0);
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
