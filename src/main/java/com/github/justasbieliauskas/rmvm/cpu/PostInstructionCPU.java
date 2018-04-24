package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Processor after instruction.
 *
 * @author Justas Bieliauskas
 */
public interface PostInstructionCPU
{
    /**
     * Creates new processor.
     *
     * @param registers old registers
     * @return processor
     */
    CPU with(Map<String, Integer> registers);
}
