package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;

import java.util.Map;

/**
 * Processor acting as given one if given id matches given string
 * and empty one otherwise.
 *
 * @author Justas Bieliauskas
 */
public class CPUIfIdMatches implements UnsafeCPU
{
    private final CPUOrEmpty processor;

    /**
     * Constructor for testing.
     *
     * @param id compared identifier as string
     * @param expected expected identifier
     * @param registerId register identifier in processor on match
     * @param word register value in processor on match
     */
    CPUIfIdMatches(String id, String expected, String registerId, long word) {
        this(
            () -> id,
            expected,
            new CPUAsUnsafe(new CPUWithRegister(registerId, word))
        );
    }

    /**
     * @param id compared identifier
     * @param expected expected identifier
     * @param processor processor on match
     */
    public CPUIfIdMatches(Id id, String expected, UnsafeCPU processor) {
        this.processor = new CPUOrEmpty(
            () -> expected.equals(id.asString()),
            processor
        );
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        return this.processor.toMap();
    }
}
