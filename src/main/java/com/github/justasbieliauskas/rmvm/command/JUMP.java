package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * JUMP command.
 * TODO: detail description of command.
 *
 * @author Justas Bieliauskas
 */
public class JUMP implements Command
{
    private final ConditionalCommand command;

    /**
     * @param counter instruction counter (IC) register
     * @param c C register
     * @param code code segment (CS) register
     * @param error program interrupt (PI) register
     */
    public JUMP(Register counter, Register c, Register code, Register error) {
        this(
            counter,
            () -> c.toInt() * Integer.BYTES + code.toInt(),
            error
        );
    }

    private JUMP(Register counter, RWord address, Register error) {
        this.command = new ConditionalCommand(
            new WordAssignment(counter, address),
            new WordAssignment(error, () -> 1),
            () -> address.toInt() < 256 * Integer.BYTES
        );
    }

    @Override
    public void execute() {
        this.command.execute();
    }
}
