package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;

/**
 * AND command.
 *
 * @author Justas Bieliauskas
 */
public class AND implements Command
{
    private final Logical conjunction;

    /**
     * @param a A register
     * @param b B register
     * @param status status register
     */
    public AND(DefaultRegister a, DefaultRegister b, DefaultRegister status) {
        this.conjunction = new Logical(a, () -> a.toInt() & b.toInt(), status);
    }

    @Override
    public void execute() {
        this.conjunction.execute();
    }
}
