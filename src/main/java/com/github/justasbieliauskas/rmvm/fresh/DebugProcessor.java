package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after "debug" command.
 *
 * TODO: better doc, tests.
 *
 * @author Justas Bieliauskas
 */
public class DebugProcessor implements UnsafeProcessor, CommandProcessor
{
    private final MutableProcessor processor;

    private final SuperInstructionProcessor newProcessor;

    private final Iterable<Boolean> next;

    /**
     * @param processor processor
     * @param newProcessor new processor
     * @param next next
     */
    public DebugProcessor(
        MutableProcessor processor,
        SuperInstructionProcessor newProcessor,
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

    @Override
    public UnsafeProcessor with(Map<String, Integer> registers, String command) {
        // TODO: construct mutable processor from given registers
        return null;
    }
}
