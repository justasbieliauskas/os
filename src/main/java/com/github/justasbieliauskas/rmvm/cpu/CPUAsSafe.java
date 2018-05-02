package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Unsafe processor masked as safe one.
 * The exception is swallowed.
 *
 * @author Justas Bieliauskas
 */
public class CPUAsSafe implements CPU
{
    private final UnsafeCPU processor;

    /**
     * @param processor unsafe processor
     */
    public CPUAsSafe(UnsafeCPU processor) {
        this.processor = processor;
    }

    @Override
    public Map<String, Long> toMap() {
        Map<String, Long> registers = null;
        try {
            registers = this.processor.toMap();
        } catch (Exception e) {}
        return registers;
    }
}
