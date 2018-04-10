package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.Command;
import com.github.justasbieliauskas.rmvm.command.Logical;
import com.github.justasbieliauskas.rmvm.data.ProcessorRegister;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * OR command.
 *
 * A = A or B
 * FIXME full comment about status
 *
 * @author Linas Jurgelėnas
 */
public class OR implements Command
{
    private final Logical disjunction;

    /**
     *
     * @param processor all registers
     */
    public OR(Register[] processor) {
        this(
                new ProcessorRegister(processor, "A"),
                new ProcessorRegister(processor, "B"),
                new ProcessorRegister(processor, "SI")
        );

    }

    /**
     *
     * @param a A register
     * @param b B register
     * @param status statis register
     */
    public OR(Register a, Register b, Register status) {
        this.disjunction = new Logical(a, () -> a.toInt() | b.toInt(), status);
    }

    @Override
    public void execute() {
        this.disjunction.execute();
    }
}
