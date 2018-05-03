package com.github.justasbieliauskas.rmvm.cpu.command;

import com.github.justasbieliauskas.rmvm.cpu.CPU;

import java.util.Map;

/**
 * Processor after "register" command.
 * Displays current register values.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterRegistersDisplay implements CPU
{
    private final CPU processor;

    /**
     * @param processor processor
     */
    public CPUAfterRegistersDisplay(CPU processor) {
        this.processor = processor;
    }

    @Override
    public Map<String, Long> toMap() {
        // TODO: use abstractions
        Map<String, Long> registers = this.processor.toMap();
        StringBuilder representation = new StringBuilder();
        for(Map.Entry<String, Long> register : registers.entrySet()) {
            representation.append(
                String.format("%s = %d, ", register.getKey(), register.getValue())
            );
        }
        System.out.println(representation.toString());
        return registers;
    }
}
