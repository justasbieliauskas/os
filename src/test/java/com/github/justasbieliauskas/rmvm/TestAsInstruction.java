package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.fake.NoMemory;
import com.github.justasbieliauskas.rmvm.instruction.Instruction;

/**
 * Instruction ran as test.
 *
 * @author Justas Bieliauskas
 */
public class TestAsInstruction implements Test
{
    private final Instruction instruction;

    private final Register[] processor;

    private final NoMemory memory;

    /**
     * @param instruction instruction
     * @param processor testing registers
     */
    public TestAsInstruction(Instruction instruction, Register[] processor) {
        this.instruction = instruction;
        this.processor = processor;
        this.memory = new NoMemory();
    }

    @Override
    public void test() {
        this.instruction.change(this.processor, this.memory);
    }
}
