package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor with ability to change its registers.
 *
 * @author Justas Bieliauskas
 */
public interface MutableProcessor extends Processor
{
    /**
     * Updates its registers to match given registers.
     *
     * @param registers new registers
     */
    void update(Map<String, Integer> registers);
}
