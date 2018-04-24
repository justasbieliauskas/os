package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Collection of registers.
 *
 * @author Justas Bieliauskas
 */
public interface Processor
{
    /**
     * Converts itself to map.
     * Keys are "A", "B", "C", "D", "ST", "IC", "PI", "SI", "TI", "CS", "PTR"
     *
     * @return map representation
     */
    Map<String, Integer> toMap();
}
