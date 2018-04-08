package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Carry;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import com.github.justasbieliauskas.rmvm.data.Overflow;
import com.github.justasbieliauskas.rmvm.data.RWord;

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
    public Logical(DefaultRegister a, RWord expression, DefaultRegister status) {
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
