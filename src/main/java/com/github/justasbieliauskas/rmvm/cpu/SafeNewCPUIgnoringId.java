package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;

import java.util.Map;

/**
 * TODO: document.
 *
 * @author Justas Bieliauskas
 */
public class SafeNewCPUIgnoringId implements UnsafeNewCPUWithId
{
    private final NewCPU processor;

    public SafeNewCPUIgnoringId(NewCPU processor) {
        this.processor = processor;
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        return this.processor.toMap();
    }

    @Override
    public UnsafeNewCPUWithId with(CPU processor, Id id) {
        return new SafeNewCPUIgnoringId(this.processor.with(processor));
    }
}
