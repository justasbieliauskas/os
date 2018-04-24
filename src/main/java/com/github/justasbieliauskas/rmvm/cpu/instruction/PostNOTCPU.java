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
public class PostNOTCPU implements CPU
{
    private final CPUWithRegister processor;

    /**
     * @param processor processor
     */
    public PostNOTCPU(CPU processor) {
        this(new CachedCPU(processor));
    }

    private PostNOTCPU(CachedCPU processor) {
        this.processor = new CPUWithRegister(
            processor,
            "A",
            () -> ~ processor.toMap().get("A")
        );
    }

    @Override
    public Map<String, Integer> toMap() {
        return this.processor.toMap();
    }
}
