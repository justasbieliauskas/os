package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Wrapper for conditional jump commands.
 *
 * NOTE: Doesn't generate programming interrupt if address is invalid
 * but condition isn't satisfied.
 *
 * @author Justas Bieliauskas
 */
public class ConditionalJump implements Command
{
    private final ConditionalCommand command;

    /**
     * @param counter instruction counter (IC) register
     * @param register register holding offset value
     * @param code code segment (CS) register
     * @param error programming interrupt (PI) register
     * @param condition condition
     */
    public ConditionalJump(
        Register counter,
        Register register,
        Register code,
        Register error,
        Condition condition
    ) {
        this.command = new ConditionalCommand(
            new JUMP(counter, register, code, error),
            new WordAssignment(counter, () -> counter.toInt() + Integer.BYTES),
            condition
        );
    }

    @Override
    public void execute() {
        this.command.execute();
    }
}
