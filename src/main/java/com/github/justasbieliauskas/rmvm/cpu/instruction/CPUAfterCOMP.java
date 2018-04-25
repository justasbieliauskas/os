package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;

import java.util.Map;

/**
 * Processor after COMP instruction.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterCOMP implements CPU
{
    private final CPUWithRegister processor;

    /**
     * @param processor processor
     */
    public CPUAfterCOMP(CPU processor) {
        this(
            processor,
            new CPURegister(processor, "A"),
            new CPURegister(processor, "B")
        );
    }

    CPUAfterCOMP(CPU processor, CPURegister a, CPURegister b) {
        this(processor, a, b, new CPURegister(processor, "ST"));
    }

    private CPUAfterCOMP(
        CPU processor,
        CPURegister a,
        CPURegister b,
        CPURegister status
    ) {
        this.processor = new CPUWithRegister(
            processor,
            new WordWithFlag(
                new WordWithFlag(
                    status,
                    'Z',
                    () -> a.toInt() == b.toInt()
                ),
                'C',
                () -> a.toInt() < b.toInt()
            )
        );
    }

    @Override
    public Map<String, Integer> toMap() {
        return this.processor.toMap();
    }
}
