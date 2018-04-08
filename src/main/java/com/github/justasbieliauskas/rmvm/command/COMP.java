package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Carry;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;

/**
 * COMP command.
 *
 * @author Justas Bieliauskas
 */
public class COMP implements Command
{
    private final Commands commands;

    /**
     * @param a A register
     * @param b B register
     * @param status status register
     */
    public COMP(DefaultRegister a, DefaultRegister b, DefaultRegister status) {
        this.commands = new Commands(
            new ZeroCheck(status, () -> a.toInt() - b.toInt()),
            new FlagAssignment(new Carry(status), () -> a.toInt() < b.toInt())
        );
    }

    @Override
    public void execute() {
        this.commands.execute();
    }
}
