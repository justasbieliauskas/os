package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.CachedCPU;
import java.util.Map;

/**
 * Processor after NOT instruction.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterNOT implements CPU
{
    private final CPUWithRegister processor;

    /**
     * @param processor processor
     */
    public CPUAfterNOT(CPU processor) {
        this(new CachedCPU(processor));
    }

    private CPUAfterNOT(CachedCPU processor) {
        this.processor = new CPUWithRegister(
            processor,
            "A",
            () -> ~ processor.toMap().get("A")
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }
}
