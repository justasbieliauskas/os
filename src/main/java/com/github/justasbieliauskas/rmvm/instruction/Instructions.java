package com.github.justasbieliauskas.rmvm.instruction;

import com.github.justasbieliauskas.rmvm.data.Memory;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Multiple instructions executed consecutively.
 *
 * @author Justas Bieliauskas
 */
public class Instructions implements Instruction
{
    private final Instruction[] instructions;

    /**
     * @param instructions instructions
     */
    public Instructions(Instruction... instructions) {
        this.instructions = instructions;
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        for(Instruction instruction : this.instructions) {
            instruction.change(processor, memory);
        }
    }
}
