package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;

import java.util.Map;

/**
 * Processor after SUB.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterSUB implements CPU
{
    private final CPUWithRegister processor;

    /**
     * @param processor processor
     */
    public CPUAfterSUB(CPU processor) {
        this(
            processor,
            new CPURegister(processor, "A"),
            new CPURegister(processor, "B")
        );
    }

    private CPUAfterSUB(CPU processor, CPURegister a, CPURegister b) {
        this.processor = new CPUWithRegister(
            new CPUAfterCOMP(processor, a, b),
            "A",
            () -> a.toInt() - b.toInt()
        );
    }

    @Override
    public Map<String, Integer> toMap() {
        return this.processor.toMap();
    }
}
