package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.MutableCPU;

/**
 * Operating system with processors.
 *
 * @author Justas Bieliauskas
 */
public class CPUOS implements OS
{
    private final MutableCPU processor;

    /**
     * @param processor processor
     */
    public CPUOS(MutableCPU processor) {
        this.processor = processor;
    }

    @Override
    public void execute(String command) throws Exception {
        try {
//            this.processor.update(
//                this.newProcessor.with(this.processor, command).toMap()
//            );
        } catch (Exception e) {
            throw new Exception(
                "Failed to execute command \"" + command + "\".",
                e
            );
        }
    }
}
