package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Register in array of registers.
 * Readonly.
 *
 * @author Justas Bieliauskas
 */
public class ProcessorRegister implements Word
{
    private final Register[] processor;

    private final Index index;

    /**
     * Constructor for indexing register with its identifier.
     *
     * @param processor all registers
     * @param id register identifier
     */
    public ProcessorRegister(Register[] processor, String id) {
        this(processor, new RegisterIndex(id));
    }

    /**
     * Default constructor.
     *
     * @param processor all registers
     * @param index register index
     */
    public ProcessorRegister(Register[] processor, Index index) {
        this.processor = processor;
        this.index = index;
    }

    @Override
    public int toInt() {
        return this.processor[this.index.toInt()].toInt();
    }
}
