package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after super instruction.
 *
 * @author Justas Bieliauskas
 */
public interface ProcessorAfterSuperInstruction
{
    /**
     * Creates new processor.
     *
     * @param registers old registers
     * @return checked processor
     */
    UnsafeProcessor with(Map<String, Integer> registers);
}
