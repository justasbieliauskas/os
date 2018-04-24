package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after NOT instruction.
 *
 * TODO: document
 *
 * @author Justas Bieliauskas
 */
public class PostNOTCPU implements CPU
{
    private final CPUWithRegister processor;

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
