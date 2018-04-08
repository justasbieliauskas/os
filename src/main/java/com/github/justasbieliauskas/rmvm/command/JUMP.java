package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.InstructionAddress;
import com.github.justasbieliauskas.rmvm.data.ProcessorRegister;
import com.github.justasbieliauskas.rmvm.data.Register;

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
     * @param register register holding offset value
     * @param code code segment (CS) register
     * @param error program interrupt (PI) register
     */
    public JUMP(Register counter, Register register, Register code, Register error) {
        this(counter, new InstructionAddress(code, register), error);
    }

    private JUMP(Register counter, InstructionAddress address, Register error) {
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
