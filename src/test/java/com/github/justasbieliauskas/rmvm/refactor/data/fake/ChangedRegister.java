package com.github.justasbieliauskas.rmvm.refactor.data.fake;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;
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
public class ChangedRegister implements Register
{
    private final Register register;

    private final Instruction instruction;

    private final Register[] wrapper;

    private final NoMemory memory;

    /**
     * @param register register to change
     * @param instruction instruction that changes register
     */
    public ChangedRegister(Register register, Instruction instruction) {
        this.register = register;
        this.instruction = instruction;
        this.wrapper = new Register[] { register };
        this.memory = new NoMemory();
    }

    @Override
    public int toInt() {
        this.instruction.change(this.wrapper, this.memory);
        return this.register.toInt();
    }

    @Override
    public void change(int value) {
        this.register.change(value);
    }
}
