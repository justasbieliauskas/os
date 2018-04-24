package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Processor after command.
 *
 * @author Justas Bieliauskas
 */
public interface CommandProcessor
{
    /**
     * Creates new processor.
     *
     * @param registers old registers
     * @param command command name
     * @return checked processor
     */
    UnsafeProcessor with(Map<String, Integer> registers, String command);
}
