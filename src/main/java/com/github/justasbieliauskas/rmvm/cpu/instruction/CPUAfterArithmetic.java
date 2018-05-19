package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.*;

import java.util.Map;

/**
 * Processor after arithmetic instruction.
 * Helper wrapper for using {@link CPUWithRegister} and {@link WordWithFlag}.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterArithmetic implements CPU
{
    private final CPUWithRegister processor;

    public CPUAfterArithmetic(CPU processor, Word result, WordWithFlag status) {
        this.processor = new CPUWithRegister(
            new CPUWithRegister(
                new CPUAfterICAdvance(processor),
                "A",
                result
            ),
            status
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }
}
