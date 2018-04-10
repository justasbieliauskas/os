package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.*;
import com.github.justasbieliauskas.rmvm.data.ProcessorRegister;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.StatusFlag;

/**
 * MUL command.
 *
 * Multiplies A with B and stores result back to A.
 *
 * @author Linas Jurgelėnas
 */

public class MUL implements Command
{
    private final Commands commands;

    /**
     *
     * @param processor all registers
     */
    public MUL(Register[] processor){
        this(
                new ProcessorRegister(processor, "A"),
                new ProcessorRegister(processor, "B"),
                new ProcessorRegister(processor, "ST")
        );
    }

    /**
     *
     * @param a A register
     * @param b B register
     * @param status Status register
     */
    public MUL(Register a, Register b, Register status) {
        this.commands = new Commands(
                new WordAssignment(a, () -> a.toInt() * b.toInt()),
                new FlagAssignment(new StatusFlag(status, 'Z'), () -> a.toInt() == 0 || b.toInt() == 0),
                new FlagAssignment(new StatusFlag(status, 'C'), () -> a.toInt() * b.toInt() > 500) //FIXME padarayt normalu Carry flaga
        );
    }

    @Override
    public void execute() {
        this.commands.execute();
    }

}
