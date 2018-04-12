package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.Memory;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;

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
