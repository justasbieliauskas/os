package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Processor with ability to change its registers.
 *
 * @author Justas Bieliauskas
 */
public interface MutableCPU extends CPU
{
    /**
     * Updates its registers to match given registers.
     *
     * @param registers new registers
     */
    void update(Map<String, Integer> registers);
}
