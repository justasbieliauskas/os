package com.github.justasbieliauskas.rmvm.instruction;

import com.github.justasbieliauskas.rmvm.data.Memory;
import com.github.justasbieliauskas.rmvm.data.Register;

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
