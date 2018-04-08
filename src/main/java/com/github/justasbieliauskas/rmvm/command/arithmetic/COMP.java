package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.Command;
import com.github.justasbieliauskas.rmvm.command.Commands;
import com.github.justasbieliauskas.rmvm.command.FlagAssignment;
import com.github.justasbieliauskas.rmvm.data.ProcessorRegister;
import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.StatusFlag;

/**
 * COMP command.
 *
 * Compares A and B. Subtracts B from A, but doesn't save result to A.
 * Status:
 * ZF = 1 if A = B, otherwise 0;
 * CF = 1 if A < B, otherwise 0.
 *
 * @author Justas Bieliauskas
 */
public class COMP implements Command
{
    private final Commands commands;

    /**
     * @param processor all registers
     */
    public COMP(Register[] processor) {
        this(
            new ProcessorRegister(processor, "A"),
            new ProcessorRegister(processor, "B"),
            new ProcessorRegister(processor, "ST")
        );
    }

    /**
     * @param a A register
     * @param b B register
     * @param status status register
     */
    public COMP(RWord a, RWord b, Register status) {
        this.commands = new Commands(
            new FlagAssignment(new StatusFlag(status, 'Z'), () -> a.toInt() == b.toInt()),
            new FlagAssignment(new StatusFlag(status, 'C'), () -> a.toInt() < b.toInt())
        );
    }

    @Override
    public void execute() {
        this.commands.execute();
    }
}
