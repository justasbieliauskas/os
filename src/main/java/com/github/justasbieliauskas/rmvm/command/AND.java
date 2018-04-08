package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.ProcessorRegister;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * AND command.
 *
 * A = A AND B
 * Status:
 * ZF = 1 if (A AND B) = 0, otherwise 0
 * CF = 0
 * OF = 0
 *
 * @author Justas Bieliauskas
 */
public class AND implements Command
{
    private final Logical conjunction;

    /**
     * @param processor all registers
     */
    public AND(Register[] processor) {
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
    public AND(Register a, Register b, Register status) {
        this.conjunction = new Logical(a, () -> a.toInt() & b.toInt(), status);
    }

    @Override
    public void execute() {
        this.conjunction.execute();
    }
}
