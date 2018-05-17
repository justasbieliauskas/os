package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;

/**
 * Processor throwing exceptions with ability to replicate itself
 * given new processor and some id.
 *
 * @author Justas Bieliauskas
 */
public interface UnsafeNewCPUWithId extends UnsafeCPU
{
    /**
     * Creates new processor from an old one and given id.
     *
     * @param processor old processor
     * @param id some id
     * @return new processor
     */
    UnsafeNewCPUWithId with(CPU processor, Id id);
}
