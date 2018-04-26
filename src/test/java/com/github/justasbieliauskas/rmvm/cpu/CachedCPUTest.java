package com.github.justasbieliauskas.rmvm.cpu;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Test for {@link CachedCPU}.
 *
 * @author Justas Bieliauskas
 */
public class CachedCPUTest
{
    @Test
    public void failsOn2() {
        CachedCPU processor = new CachedCPU(
            new CPU() {
                private int count = 1;
                @Override
                public Map<String, Long> toMap() {
                    if(this.count == 2) {
                        fail("toMap() called twice.");
                    }
                    return null;
                }
            }
        );
        processor.toMap();
        processor.toMap();
    }
}