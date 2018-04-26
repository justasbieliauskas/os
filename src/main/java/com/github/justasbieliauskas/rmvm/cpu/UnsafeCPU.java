package com.github.justasbieliauskas.rmvm.cpu;

import java.util.Map;

/**
 * Checked processor that raises exceptions.
 *
 * @author Justas Bieliauskas
 */
public interface UnsafeCPU
{
    /**
     * Converts itself to map.
     * @see CPU
     *
     * @return map representation
     * @throws Exception if converting to map fails
     */
    Map<String, Long> toMap() throws Exception;
}
