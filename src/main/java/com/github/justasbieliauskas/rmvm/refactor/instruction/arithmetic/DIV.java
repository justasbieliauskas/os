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
     * Constructor for testing.
     *
     * @param resultIndex result register index as integer
     * @param dividend dividend as integer
     * @param divisor divisor as integer
     * @param errorIndex error register index as integer
     */
    DIV(int resultIndex, int dividend, int divisor, int errorIndex) {
        this(() -> resultIndex, () -> dividend, () -> divisor, () -> errorIndex);
    }

    private DIV(Index resultIndex, Word dividend, Word divisor, Index errorIndex) {
        this.instruction = new ConditionalInstruction(
            new RegisterAssignment(errorIndex, 2),
            new RegisterAssignment(
                resultIndex,
                () -> dividend.toInt() / divisor.toInt()
            ),
            () -> divisor.toInt() == 0
        );
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        this.instruction.change(processor, memory);
    }
}
