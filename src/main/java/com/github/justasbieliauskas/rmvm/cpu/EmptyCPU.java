package com.github.justasbieliauskas.rmvm.cpu;

import java.util.HashMap;
import java.util.Map;

/**
 * Empty processor.
 *
 * @author Justas Bieliauskas
 */
public class EmptyCPU implements CPU
{
    @Override
    public Map<String, Long> toMap() {
        return new HashMap<>();
    }
}
