package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;

import java.util.Map;

/**
 * TODO: document.
 *
 * @author Justas Bieliauskas
 */
public class SafeNewCPUWithId implements UnsafeNewCPUWithId
{
    private final NewCPUWithId processor;

    public SafeNewCPUWithId(NewCPUWithId processor) {
        this.processor = processor;
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        return this.processor.toMap();
    }

    @Override
    public UnsafeNewCPUWithId with(CPU processor, Id id) {
        return new SafeNewCPUWithId(this.processor.with(processor, id));
    }
}
