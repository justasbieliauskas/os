package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.NewCPU;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;

import java.util.HashMap;
import java.util.Map;

/**
 * Processor after COMP instruction.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterCOMP implements NewCPU
{
    private final CPUWithRegister processor;

    public CPUAfterCOMP() {
        this(() -> new HashMap<>());
    }

    private CPUAfterCOMP(CPU processor) {
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
                    () -> a.toLong() == b.toLong()
                ),
                'C',
                () -> a.toLong() < b.toLong()
            )
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }

    @Override
    public NewCPU with(CPU processor) {
        return new CPUAfterCOMP(processor);
    }
}
