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
     * Constructor for simple value assignments.
     *
     * @param index register index
     * @param word new value as integer
     */
    public RegisterAssignment(Index index, int word) {
        this(index, () -> word);
    }

    /**
     * Constructor used in testing where a single register is changed.
     *
     * @param word new value as integer
     */
    RegisterAssignment(int word) {
        this(() -> 0, () -> word);
    }

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
