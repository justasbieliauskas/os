package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Processor after super instruction.
 *
 * @author Justas Bieliauskas
 */
public interface PostSupervisorCPU
{
    /**
     * Creates new processor.
     *
     * @param registers old registers
     * @return checked processor
     */
    UnsafeCPU with(Map<String, Integer> registers);
}
