package com.github.justasbieliauskas.rmvm.cpu;

/**
 * Processor after command.
 *
 * @author Justas Bieliauskas
 */
public interface PostMasterCommandCPU
{
    /**
     * Creates new processor.
     *
     * @param processor old processor
     * @param command command name
     * @return new processor
     */
    UnsafeCPU with(CPU processor, String command);
}
