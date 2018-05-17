package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Decorator processor outputs registers to stdout on update.
 *
 * @author Justas Bieliauskas
 */
public class DisplayCPU implements MutableCPU
{
    private final MutableCPU processor;

    /**
     * @param processor processor
     */
    public DisplayCPU(MutableCPU processor) {
        this.processor = processor;
    }

    @Override
    public void update(Map<String, Long> registers) {
        this.processor.update(registers);
        StringBuilder representation = new StringBuilder();
        for(Map.Entry<String, Long> register : registers.entrySet()) {
            representation.append(
                String.format("%s = %d, ", register.getKey(), register.getValue())
            );
        }
        System.out.println(representation.toString());
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }
}
