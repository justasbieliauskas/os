package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;
import com.github.justasbieliauskas.rmvm.refactor.data.Word;
import com.github.justasbieliauskas.rmvm.refactor.instruction.Instruction;

/**
 * Register instruction changed its value.
 * Used in testing.
 *
 * Since the length of register array is 1,
 * pass 0 as index to all instruction objects.
 *
 * @author Justas Bieliauskas
 */
public class ChangedRegister implements Word
{
    private final Register register;

    private final Instruction instruction;

    private final Register[] wrapper;

    private final NoMemory memory;

    /**
     * @param instruction instruction
     */
    public ChangedRegister(Instruction instruction) {
        this.register = new FakeRegister();
        this.instruction = instruction;
        this.wrapper = new Register[] { this.register };
        this.memory = new NoMemory();
    }

    @Override
    public int toInt() {
        this.instruction.change(this.wrapper, this.memory);
        return this.register.toInt();
    }
}
