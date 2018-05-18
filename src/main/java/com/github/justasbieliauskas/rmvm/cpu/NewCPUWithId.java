package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;

/**
 * Same as {@link NewCPU} except new processor is created
 * using extra identifier.
 *
 * @author Justas Bieliauskas
 */
public interface NewCPUWithId extends CPU
{
    /**
     * Creates new processor from old one and some id.
     *
     * @param processor old processor
     * @param id identifier
     * @return new processor
     */
    NewCPUWithId with(CPU processor, Id id);
}
