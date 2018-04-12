package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.Memory;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;

/**
 * Instruction.
 *
 * @author Justas Bieliauskas
 */
public interface Instruction
{
    /**
     * Modify registers, memory.
     *
     * @param processor all registers
     * @param memory user memory
     */
    void change(Register[] processor, Memory memory);
}
