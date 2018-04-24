package com.github.justasbieliauskas.rmvm.fresh;

import java.util.Map;

/**
 * Checked processor that raises exceptions.
 *
 * @author Justas Bieliauskas
 */
public interface UnsafeProcessor
{
    /**
     * Converts itself to map.
     * @see Processor
     *
     * @return map representation
     * @throws Exception if converting to map fails
     */
    Map<String, Integer> toMap() throws Exception;
}
