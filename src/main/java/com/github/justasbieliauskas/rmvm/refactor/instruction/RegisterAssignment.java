package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.*;

/**
 * Assigning of word value to register.
 *
 * @author Justas Bieliauskas
 */
public class RegisterAssignment implements Instruction
{
    private final Index index;

    private final Word word;

    /**
     * Default constructor.
     *
     * @param index register index
     * @param word new value
     */
    public RegisterAssignment(Index index, Word word) {
        this.index = index;
        this.word = word;
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        processor[this.index.toInt()].change(this.word.toInt());
    }
}
