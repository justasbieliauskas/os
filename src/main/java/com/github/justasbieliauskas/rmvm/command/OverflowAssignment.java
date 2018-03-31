package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Overflow flag assignment.
 * Wrapper for {@link FlagAssignment} with the right index to status register.
 *
 * FIXME: is this and {@link CarryAssignment} necessary?
 *
 * @author Justas Bieliauskas
 */
public class OverflowAssignment implements Command
{
    private final FlagAssignment assignOverflow;

    /**
     * @param status status register
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public OverflowAssignment(Register status, Condition to1) {
        this.assignOverflow = new FlagAssignment(status, 0, 2, to1);
    }

    @Override
    public void execute() {
        this.assignOverflow.execute();
    }
}
