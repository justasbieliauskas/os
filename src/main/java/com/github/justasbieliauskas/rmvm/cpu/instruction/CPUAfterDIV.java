package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.CachedCPU;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import java.util.Map;

/**
 * Processor after DIV instruction.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterDIV implements CPU
{
    private final CPUAfterTernary processor;

    /**
     * Constructor for testing.
     * Creates processor from 2 numbers.
     *
     * @param dividend dividend as integer
     * @param divisor divisor as integer
     * @param error initial error as integer
     */
    CPUAfterDIV(int dividend, int divisor, int error) {
        this(
            new CPUWithRegister(
                new CPUWithRegister(
                    new CPUWithRegister("A", dividend),
                    "B",
                    divisor
                ),
                "PI",
                error
            )
        );
    }

    /**
     * Default constructor.
     *
     * @param processor processor
     */
    public CPUAfterDIV(CPU processor) {
        this(new CachedCPU(processor));
    }

    private CPUAfterDIV(CachedCPU processor) {
        this(
            processor,
            new CPURegister(processor, "A"),
            new CPURegister(processor, "B")
        );
    }

    private CPUAfterDIV(
        CachedCPU processor,
        CPURegister dividend,
        CPURegister divisor
    ) {
        this.processor = new CPUAfterTernary(
            () -> divisor.toInt() != 0,
            new CPUWithRegister(
                processor,
                "A",
                () -> dividend.toInt() / divisor.toInt()
            ),
            new CPUWithRegister(processor, "PI", 2)
        );
    }

    @Override
    public Map<String, Integer> toMap() {
        return this.processor.toMap();
    }
}
