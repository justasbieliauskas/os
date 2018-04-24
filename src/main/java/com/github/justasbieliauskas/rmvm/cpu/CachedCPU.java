package com.github.justasbieliauskas.rmvm.cpu;

import java.util.ArrayList;
import java.util.Map;

/**
 * Processor with cached map representation.
 *
 * TODO: test, document.
 *
 * @author Justas Bieliauskas
 */
public class CachedCPU implements CPU
{
    private final CPU processor;

    private final ArrayList<Map<String, Integer>> storage;

    public CachedCPU(CPU processor) {
        this.processor = processor;
        this.storage = new ArrayList<>(1);
    }

    @Override
    public Map<String, Integer> toMap() {
        if(this.storage.isEmpty()) {
            this.storage.add(this.processor.toMap());
        }
        return this.storage.get(0);
    }
}
