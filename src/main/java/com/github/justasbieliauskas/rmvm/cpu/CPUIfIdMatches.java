package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;
import com.github.justasbieliauskas.rmvm.data.IdEquality;
import com.github.justasbieliauskas.rmvm.data.IdMatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Processor acting as given one if given id matches given string
 * and empty one otherwise.
 *
 * @author Justas Bieliauskas
 */
public class CPUIfIdMatches implements UnsafeNewCPUWithId
{
    private final TernaryCPU processor;

    private final IdMatch match;

    private final UnsafeNewCPUWithId origin;

    public CPUIfIdMatches(String expected, UnsafeNewCPUWithId processor) {
        this(new IdEquality(expected), processor);
    }

    /**
     * @param match whether id matches
     * @param processor processor to act as if that id matches
     */
    public CPUIfIdMatches(IdMatch match, UnsafeNewCPUWithId processor) {
        this.processor = new TernaryCPU(match, processor, () -> new HashMap<>());
        this.match = match;
        this.origin = processor;
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        return this.processor.toMap();
    }

    @Override
    public UnsafeNewCPUWithId with(CPU processor, Id id) {
        return new CPUIfIdMatches(
            this.match.with(id),
            this.origin.with(processor, id)
        );
    }
}
