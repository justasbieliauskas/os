package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.*;

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
     * @param register register holding new counter value
     * @param code code segment (CS) register
     * @param error program interrupt (PI) register
     * @param status status (ST) register
     */
    public JLE(
        Register counter,
        Register register,
        Register code,
        Register error,
        Register status
    ) {
        this(
            counter,
            register,
            code,
            error,
            new StatusFlag(status, 'Z'),
            new StatusFlag(status, 'C')
        );
    }

    private JLE(
        Register counter,
        Register c,
        Register code,
        Register error,
        StatusFlag zero,
        StatusFlag carry
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
