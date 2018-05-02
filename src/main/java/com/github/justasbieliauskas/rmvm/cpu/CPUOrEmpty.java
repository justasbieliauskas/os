package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Condition;

import java.util.HashMap;
import java.util.Map;

/**
 * Ternary processor with empty one as alternative.
 *
 * @author Justas Bieliauskas
 */
public class CPUOrEmpty implements UnsafeCPU
{
    private final TernaryCPU processor;

    /**
     * @param condition whether to act as given processor or empty one
     * @param processor processor if condition is true
     */
    public CPUOrEmpty(Condition condition, UnsafeCPU processor) {
        this.processor = new TernaryCPU(condition, processor, () -> new HashMap<>());
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        return this.processor.toMap();
    }
}
