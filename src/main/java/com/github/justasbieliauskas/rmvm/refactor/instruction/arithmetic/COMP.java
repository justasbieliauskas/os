package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.data.*;
import com.github.justasbieliauskas.rmvm.refactor.instruction.Instruction;
import com.github.justasbieliauskas.rmvm.refactor.instruction.RegisterAssignment;

/**
 * COMP instruction.
 *
 * Compares two registers.
 * Sets zero flag to 1 if the two registers are equal to each other, 0 otherwise;
 * Sets carry flag to 1 if the first register is less than the second, 0 otherwise.
 *
 * @author Justas Bieliauskas
 */
public class COMP implements Instruction
{
    private final RegisterAssignment assignment;

    /**
     * Constructor for testing.
     *
     * @param status status register constructed hand-picking flag values
     * @param first first operand as integer
     * @param second second operand as integer
     */
    COMP(WordWithFlag status, int first, int second) {
        this(() -> 0, status, () -> first, () -> second);
    }

    private COMP(Index statusIndex, Word status, Word first, Word second) {
        this.assignment = new RegisterAssignment(
            statusIndex,
            new WordWithFlag(
                new WordWithFlag(
                    status,
                    'Z',
                    () -> first.toInt() == second.toInt()
                ),
                'C',
                () -> first.toInt() < second.toInt()
            )
        );
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        this.assignment.change(processor, memory);
    }
}
