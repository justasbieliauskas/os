package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Carry;
import com.github.justasbieliauskas.rmvm.data.Overflow;
import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Wrapper for AND, OR, XOR commands.
 *
 * @author Justas Bieliauskas
 */
public class Logical implements Command
{
    private final Commands commands;

    /**
     * @param a A register
     * @param expression word expression
     * @param status status register
     */
    public Logical(Register a, RWord expression, Register status) {
        this.commands = new Commands(
            new WordAssignment(a, expression),
            new ZeroCheck(status, expression),
            new FlagAssignment(new Carry(status), () -> false),
            new FlagAssignment(new Overflow(status), () -> false)
        );
    }

    @Override
    public void execute() {
        this.commands.execute();
    }
}
