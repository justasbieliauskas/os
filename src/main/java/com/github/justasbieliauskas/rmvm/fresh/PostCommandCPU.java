package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after command.
 *
 * @author Justas Bieliauskas
 */
public interface PostCommandCPU
{
    /**
     * Creates new processor.
     *
     * @param registers old registers
     * @param command command name
     * @return checked processor
     */
    UnsafeCPU with(Map<String, Integer> registers, String command);
}
