package com.github.justasbieliauskas.rmvm.data;

/**
 * Synonymous to bit inside a register.
 *
 * @see StatusFlag
 * @author Justas Bieliauskas
 */
public interface Flag extends Condition
{
    /**
     * Change value.
     *
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    void assign(boolean to1);
}
