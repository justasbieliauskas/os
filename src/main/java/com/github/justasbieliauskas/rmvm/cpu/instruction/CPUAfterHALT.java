package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.NewCPU;

import java.util.HashMap;
import java.util.Map;

/**
 * Processor after HALT instruction.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterHALT implements NewCPU
{
    private final CPUWithRegister processor;

    public CPUAfterHALT() {
        this(() -> new HashMap<>());
    }

    /**
     * @param processor processor
     */
    public CPUAfterHALT(CPU processor) {
        this.processor = new CPUWithRegister(
            new CPUAfterICAdvance(processor),
            "SI",
            6
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }

    @Override
    public NewCPU with(CPU processor) {
        return new CPUAfterHALT(processor);
    }
}
