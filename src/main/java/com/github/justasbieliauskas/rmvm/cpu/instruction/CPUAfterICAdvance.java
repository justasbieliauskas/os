package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;

import java.util.Map;

/**
 * Processor after instruction with normal flow control.
 * IC register is incremented by 1.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterICAdvance implements CPU
{
    private final CPUWithRegister processor;

    /**
     * @param processor processor
     */
    public CPUAfterICAdvance(CPU processor) {
        this(processor, new CPURegister(processor, "IC"));
    }

    private CPUAfterICAdvance(CPU processor, CPURegister counter) {
        this.processor = new CPUWithRegister(
            processor,
            "IC",
            () -> counter.toLong() + 1
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }
}
