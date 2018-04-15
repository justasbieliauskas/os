package com.github.justasbieliauskas.rmvm.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.data.Index;
import com.github.justasbieliauskas.rmvm.data.Memory;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.Word;
import com.github.justasbieliauskas.rmvm.instruction.RegisterAssignment;
import com.github.justasbieliauskas.rmvm.instruction.Instruction;

/**
 * NOT instruction.
 *
 * Calculates {@code A = ~A}.
 * Doesn't change the status register.
 *
 * @author Justas Bieliauskas
 */
public class NOT implements Instruction
{
    private final RegisterAssignment assignment;

    /**
     * Constructor for testing instruction.
     *
     * @param word word to negate as integer
     */
    NOT(int word) {
        this(() -> 0, () -> word);
    }

    private NOT(Index index, Word word) {
        this.assignment = new RegisterAssignment(index, () -> ~ word.toInt());
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        this.assignment.change(processor, memory);
    }
}
