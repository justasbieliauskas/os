package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.data.*;
import com.github.justasbieliauskas.rmvm.refactor.instruction.ConditionalInstruction;
import com.github.justasbieliauskas.rmvm.refactor.instruction.Instruction;
import com.github.justasbieliauskas.rmvm.refactor.instruction.RegisterAssignment;

/**
 * DIV instruction.
 *
 * Calculates {@code A = A / B}.
 * Doesn't change status register.
 * If B is zero, no division is performed and error register is set to 2 instead.
 *
 * @author Justas Bieliauskas
 */
public class DIV implements Instruction
{
    private final ConditionalInstruction instruction;

    /**
     * Constructor for pre-defined registers in processor.
     *
     * @param processor all registers
     */
    public DIV(Register[] processor) {
        this(processor, new RegisterIndex("A"));
    }

    /**
     * Constructor for testing.
     *
     * @param resultIndex result register index as integer
     * @param errorIndex error register index as integer
     * @param dividend dividend as integer
     * @param divisor divisor as integer
     */
    DIV(int resultIndex, int errorIndex, int dividend, int divisor) {
        this(() -> resultIndex, () -> errorIndex, () -> dividend, () -> divisor);
    }

    private DIV(Register[] processor, RegisterIndex aIndex) {
        this(
            aIndex,
            new RegisterIndex("PI"),
            new ProcessorRegister(processor, aIndex),
            new ProcessorRegister(processor, "B")
        );
    }

    private DIV(Index resultIndex, Index errorIndex, Word dividend, Word divisor) {
        this.instruction = new ConditionalInstruction(
            new RegisterAssignment(
                resultIndex,
                () -> dividend.toInt() / divisor.toInt()
            ),
            new RegisterAssignment(errorIndex, 2),
            () -> divisor.toInt() != 0
        );
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        this.instruction.change(processor, memory);
    }
}
