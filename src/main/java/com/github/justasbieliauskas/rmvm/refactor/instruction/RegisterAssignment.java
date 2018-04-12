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
     * Constructor for indexing register with its identifier.
     * For possible register identifiers, see {@link RegisterIndex}.
     *
     * @param id register identifier
     * @param word new value
     */
    public RegisterAssignment(String id, Word word) {
        this(new RegisterIndex(id), word);
    }

    /**
     * Constructor for testing.
     *
     * @param index register index as integer
     * @param word new value as integer
     */
    RegisterAssignment(int index, int word) {
        this(() -> index, () -> word);
    }

    /**
     * Default constructor.
     *
     * @param index register index
     * @param word new value
     */
    RegisterAssignment(Index index, Word word) {
        this.index = index;
        this.word = word;
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        processor[this.index.toInt()].change(this.word.toInt());
    }
}
