package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Register;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.NoMemory;
import com.github.justasbieliauskas.rmvm.refactor.instruction.Instruction;

/**
 * Instruction ran as test.
 *
 * @author Justas Bieliauskas
 */
public class InstructionAsTest implements Test
{
    private final Instruction instruction;

    private final Register[] processor;

    private final NoMemory memory;

    /**
     * @param instruction instruction
     * @param processor testing registers
     */
    public InstructionAsTest(Instruction instruction, Register[] processor) {
        this.instruction = instruction;
        this.processor = processor;
        this.memory = new NoMemory();
    }

    @Override
    public void test() {
        this.instruction.change(this.processor, this.memory);
    }
}
