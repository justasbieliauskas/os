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
