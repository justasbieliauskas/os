package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Collection of registers.
 *
 * @author Justas Bieliauskas
 */
public interface CPU
{
    /**
     * Converts itself to map.
     * Keys are "A", "B", "C", "D", "ST", "IC", "PI", "SI", "TI", "CS", "PTR"
     *
     * @return map representation
     */
    Map<String, Long> toMap();
}
