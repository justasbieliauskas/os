package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUAsSafe;
import com.github.justasbieliauskas.rmvm.cpu.UnsafeCPU;

/**
 * Register in processor.
 * For possible register identifiers, see {@link CPU}.
 *
 * @author Justas Bieliauskas
 */
public class CPURegister implements Word
{
    private final CPU processor;

    private final Id id;

    public CPURegister(UnsafeCPU processor, String id) {
        this(new CPUAsSafe(processor), id);
    }

    public CPURegister(CPU processor, String id) {
        this(processor, () -> id);
    }

    /**
     * Constructor for initializing with unsafe processor.
     *
     * @param processor unsafe processor
     * @param id register identifier
     */
    public CPURegister(UnsafeCPU processor, Id id) {
        this(new CPUAsSafe(processor), id);
    }

    /**
     * Default constructor.
     *
     * @param processor processor
     * @param id register identifier
     */
    public CPURegister(CPU processor, Id id) {
        this.processor = processor;
        this.id = id;
    }

    @Override
    public long toLong() {
        return this.processor.toMap().get(this.id.asString());
    }
}
