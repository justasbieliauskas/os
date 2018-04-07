package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Carry;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.Zero;

/**
 * JLE command.
 *
 * @author Justas Bieliauskas
 */
public class JLE implements Command
{
    private final ConditionalJump jump;

    /**
     * @param counter instruction counter (IC) register
     * @param c C register
     * @param code code segment (CS) register
     * @param error program interrupt (PI) register
     * @param status status (ST) register
     */
    public JLE(
        Register counter,
        Register c,
        Register code,
        Register error,
        Register status
    ) {
        this(counter, c, code, error, new Zero(status), new Carry(status));
    }

    private JLE(
        Register counter,
        Register c,
        Register code,
        Register error,
        Zero zero,
        Carry carry
    ) {
        this.jump = new ConditionalJump(
            counter,
            c,
            code,
            error,
            () -> zero.isTrue() && carry.isTrue()
        );
    }

    @Override
    public void execute() {
        this.jump.execute();
    }
}
