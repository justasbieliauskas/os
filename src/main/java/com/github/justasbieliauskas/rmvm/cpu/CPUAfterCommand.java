package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.cpu.command.CPUAfterRegistersDisplay;

import java.util.Map;

/**
 * Processor after command is executed.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterCommand implements UnsafeCPU
{
    private final FirstNonEmptyCPU processor;

    public CPUAfterCommand(CPU processor, String command) {
        this.processor = new FirstNonEmptyCPU(
            new CPUIfIdMatches(
                command,
                "registers",
                new CPUAfterRegistersDisplay(processor)
            )
        );
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        // TODO: catch and rethrow
        return this.processor.toMap();
    }
}
