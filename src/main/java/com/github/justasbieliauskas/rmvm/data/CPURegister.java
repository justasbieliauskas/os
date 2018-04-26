package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.cpu.CPU;

/**
 * Register in processor.
 * For possible register identifiers, see {@link CPU}.
 *
 * @author Justas Bieliauskas
 */
public class CPURegister implements Word
{
    private final CPU processor;

    private final String id;

    /**
     * @param processor processor
     * @param id register identifier
     */
    public CPURegister(CPU processor, String id) {
        this.processor = processor;
        this.id = id;
    }

    @Override
    public long toLong() {
        return this.processor.toMap().get(this.id);
    }
}
