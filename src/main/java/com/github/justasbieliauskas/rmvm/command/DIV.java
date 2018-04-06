package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * DIV command.
 *
 * @author Justas Bieliauskas
 */
public class DIV implements Command
{
    private final ConditionalCommand command;

    /**
     * @param a A register
     * @param b B register
     * @param programInterrupt program interrupts register
     */
    public DIV(Register a, Register b, Register programInterrupt) {
        this.command = new ConditionalCommand(
            new WordAssignment(a, () -> a.toInt() / b.toInt()),
            new WordAssignment(programInterrupt, () -> 2),
            () -> b.toInt() != 0
        );
    }

    @Override
    public void execute() {
        this.command.execute();
    }
}
