package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Processor after super instruction.
 *
 * @author Justas Bieliauskas
 */
public interface CPUAfterSupervisor extends UnsafeCPU
{
    /**
     * Creates new processor.
     *
     * @param processor old processor
     * @return new processor
     */
    CPUAfterSupervisor with(CPU processor);
}
