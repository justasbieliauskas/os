package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.InstructionAddress;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;

/**
 * JUMP command.
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
    public JUMP(DefaultRegister counter, DefaultRegister c, DefaultRegister code, DefaultRegister error) {
        this(counter, new InstructionAddress(code, c), error);
    }

    private JUMP(DefaultRegister counter, InstructionAddress address, DefaultRegister error) {
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
