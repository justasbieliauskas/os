package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Safe processor masked as unsafe.
 *
 * @author Justas Bieliauskas
 */
public class CPUAsUnsafe implements UnsafeCPU
{
    private final CPU processor;

    /**
     * @param processor safe processor
     */
    public CPUAsUnsafe(CPU processor) {
        this.processor = processor;
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        return this.processor.toMap();
    }
}
