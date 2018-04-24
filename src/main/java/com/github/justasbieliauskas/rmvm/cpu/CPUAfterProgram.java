package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Processor after program run.
 *
 * TODO: better doc, tests.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterProgram implements UnsafeCPU
{
    private final MutableCPU processor;

    private final CPUAfterSupervisor newProcessor;

    private final Iterable<Boolean> next;

    /**
     * @param processor processor
     * @param newProcessor new processor
     * @param next next
     */
    public CPUAfterProgram(
        MutableCPU processor,
        CPUAfterSupervisor newProcessor,
        Iterable<Boolean> next
    ) {
        this.processor = processor;
        this.newProcessor = newProcessor;
        this.next = next;
    }

    @Override
    public Map<String, Integer> toMap() throws Exception {
        for(boolean next : this.next) {
            if(!next) {
                break;
            }
            try {
                this.processor.update(
                    this.newProcessor.with(this.processor).toMap()
                );
            } catch (Exception e) {
                throw new Exception("Failed to run next instruction!", e);
            }
        }
        return this.processor.toMap();
    }
}
