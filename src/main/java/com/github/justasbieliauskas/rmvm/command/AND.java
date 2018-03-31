package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.LWord;
import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * AND command.
 *
 * @author Justas Bieliauskas
 */
public class AND implements Command
{
    private final Commands and;

    /**
     * @param lWord assigned self AND rWord
     * @param rWord word expression
     * @param status status register to modify
     */
    public AND(LWord lWord, RWord rWord, Register status) {
        this.and = new Commands(
            new ZeroAssignment(lWord, () -> lWord.toInt() & rWord.toInt(), status),
            new CarryAssignment(status, () -> false),
            new OverflowAssignment(status, () -> false)
        );
    }

    @Override
    public void execute() {
        this.and.execute();
    }
}
