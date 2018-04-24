package com.github.justasbieliauskas.rmvm.fresh;

/**
 * Operating system with processors.
 *
 * @author Justas Bieliauskas
 */
public class ProcessorOS implements OS
{
    private final MutableProcessor processor;

    private final CommandProcessor commandProcessor;

    /**
     * @param processor processor
     * @param commandProcessor processor for commands
     */
    public ProcessorOS(MutableProcessor processor, CommandProcessor commandProcessor) {
        this.processor = processor;
        this.commandProcessor = commandProcessor;
    }

    @Override
    public void execute(String command) throws Exception {
        try {
            this.processor.update(
                this.commandProcessor.with(
                    this.processor.toMap(),
                    command
                ).toMap()
            );
        } catch (Exception e) {
            throw new Exception(
                String.format("Failed to execute command \"%s\"", command),
                e
            );
        }
    }
}
