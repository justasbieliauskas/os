package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.MutableCPU;
import com.github.justasbieliauskas.rmvm.cpu.UnsafeNewCPUWithId;
import com.github.justasbieliauskas.rmvm.data.Id;

/**
 * Operating system with processors.
 *
 * @author Justas Bieliauskas
 */
public class OSWithCPU implements OS
{
    private final MutableCPU processor;

    private final UnsafeNewCPUWithId newProcessor;

    /**
     * @param processor processor
     * @param newProcessor new processor
     */
    public OSWithCPU(MutableCPU processor, UnsafeNewCPUWithId newProcessor) {
        this.processor = processor;
        this.newProcessor = newProcessor;
    }

    @Override
    public void execute(Id command) throws Exception {
        try {
            this.processor.update(
                this.newProcessor.with(this.processor, command).toMap()
            );
        } catch (Exception e) {
            throw new Exception(
                "Failed to execute command \"" + command.asString() + "\".",
                e
            );
        }
    }
}
