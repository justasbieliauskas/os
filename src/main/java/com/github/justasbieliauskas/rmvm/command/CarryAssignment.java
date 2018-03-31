package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Carry flag assignment.
 * Wrapper for {@link FlagAssignment} with the right index to status register.
 *
 * FIXME: is this and {@link OverflowAssignment} necessary?
 *
 * @author Justas Bieliauskas
 */
public class CarryAssignment implements Command
{
    private final FlagAssignment assignCarry;

    /**
     * @param status status register
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public CarryAssignment(Register status, Condition to1) {
        this.assignCarry = new FlagAssignment(status, 0, 1, to1);
    }

    @Override
    public void execute() {
        this.assignCarry.execute();
    }
}
