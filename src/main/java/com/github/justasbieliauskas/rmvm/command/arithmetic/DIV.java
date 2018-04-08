package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.Command;
import com.github.justasbieliauskas.rmvm.command.ConditionalCommand;
import com.github.justasbieliauskas.rmvm.command.WordAssignment;
import com.github.justasbieliauskas.rmvm.data.ProcessorRegister;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * DIV command.
 *
 * Divides A by B and stores result back to A.
 * Doesn't change status register.
 * If B = 0, sets PI register to 2.
 *
 * @author Justas Bieliauskas
 */
public class DIV implements Command
{
    private final ConditionalCommand command;

    /**
     * @param processor all registers
     */
    public DIV(Register[] processor) {
        this(
            new ProcessorRegister(processor, "A"),
            new ProcessorRegister(processor, "B"),
            new ProcessorRegister(processor, "PI")
        );
    }

    /**
     * @param a A register
     * @param b B register
     * @param error program interrupt (PI) register
     */
    public DIV(Register a, Register b, Register error) {
        this.command = new ConditionalCommand(
            new WordAssignment(a, () -> a.toInt() / b.toInt()),
            new WordAssignment(error, () -> 2),
            () -> b.toInt() != 0
        );
    }

    @Override
    public void execute() {
        this.command.execute();
    }
}
