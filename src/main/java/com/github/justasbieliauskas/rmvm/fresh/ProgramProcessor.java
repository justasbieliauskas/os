package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after program run.
 *
 * TODO: better doc, tests.
 *
 * @author Justas Bieliauskas
 */
public class ProgramProcessor implements UnsafeProcessor
{
    private final MutableProcessor processor;

    private final ProcessorAfterSuperInstruction newProcessor;

    private final Iterable<Boolean> next;

    /**
     * @param processor processor
     * @param newProcessor new processor
     * @param next next
     */
    public ProgramProcessor(
        MutableProcessor processor,
        ProcessorAfterSuperInstruction newProcessor,
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
                    this.newProcessor.with(this.processor.toMap()).toMap()
                );
            } catch (Exception e) {
                throw new Exception("Failed to run next instruction!", e);
            }
        }
        return this.processor.toMap();
    }
}
