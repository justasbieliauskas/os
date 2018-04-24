package com.github.justasbieliauskas.rmvm.cpu;

/**
 * Processor after instruction.
 *
 * @author Justas Bieliauskas
 */
public interface CPUAfterInstruction
{
    /**
     * Creates new processor.
     *
     * @param processor old processor
     * @return new processor
     */
    CPU with(CPU processor);
}
