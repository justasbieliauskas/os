package com.github.justasbieliauskas.rmvm.cpu;

/**
 * Processor after instruction.
 *
 * @author Justas Bieliauskas
 */
public interface CPUAfterInstruction extends CPU
{
    /**
     * Creates new processor.
     *
     * @param processor old processor
     * @return new processor
     */
    CPUAfterInstruction with(CPU processor);
}
