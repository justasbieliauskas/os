package com.github.justasbieliauskas.rmvm.cpu;

/**
 * Processor after executing an os command.
 *
 * @author Justas Bieliauskas
 */
public interface CPUAfterCommand extends UnsafeCPU
{
    /**
     * Creates new processor.
     *
     * @param processor old processor
     * @param name command name
     * @return new processor
     */
    CPUAfterCommand with(CPU processor, String name);
}
