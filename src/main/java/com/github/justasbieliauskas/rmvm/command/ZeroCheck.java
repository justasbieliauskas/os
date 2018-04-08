package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import com.github.justasbieliauskas.rmvm.data.Zero;

/**
 * Assigns ZF = 1 if expression evaluates to zero, 0 otherwise.
 *
 * @author Justas Bieliauskas
 */
public class ZeroCheck implements Command
{
    private final FlagAssignment flagAssignment;

    /**
     * @param status status register
     * @param expression word expression
     */
    public ZeroCheck(DefaultRegister status, RWord expression) {
        this.flagAssignment = new FlagAssignment(
            new Zero(status),
            () -> expression.toInt() == 0
        );
    }

    @Override
    public void execute() {
        this.flagAssignment.execute();
    }
}
