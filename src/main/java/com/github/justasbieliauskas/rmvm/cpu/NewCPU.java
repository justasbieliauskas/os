package com.github.justasbieliauskas.rmvm.cpu;

/**
 * Processor with ability to create new processor from an old one.
 * The new processor doesn't throw exceptions.
 *
 * @author Justas Bieliauskas
 */
public interface NewCPU extends CPU
{
    /**
     * Create new processor from an old one.
     *
     * @param processor old processor
     * @return new processor
     */
    NewCPU with(CPU processor);
}
