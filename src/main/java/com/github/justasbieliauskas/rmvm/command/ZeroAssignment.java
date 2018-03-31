package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.LWord;
import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Assigns word and ZF to 1 if rword is zero.
 *
 * @author Justas Bieliauskas
 */
public class ZeroAssignment implements Command
{
    private final Commands assignment;

    public ZeroAssignment(LWord lWord, RWord rWord, Register status) {
        this.assignment = new Commands(
            new WordAssignment(lWord, rWord),
            new FlagAssignment(status, 0, () -> rWord.toInt() == 0)
        );
    }

    @Override
    public void execute() {
        this.assignment.execute();
    }
}
