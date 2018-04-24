package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after instruction.
 *
 * @author Justas Bieliauskas
 */
public interface ProcessorAfterInstruction
{
    /**
     * Creates new processor.
     *
     * @param registers old registers
     * @return processor
     */
    Processor with(Map<String, Integer> registers);
}
