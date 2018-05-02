package com.github.justasbieliauskas.rmvm.cpu;

import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.*;

/**
 * Test for {@link CPUOrEmpty}.
 *
 * TODO: oop tests
 *
 * @author Justas Bieliauskas
 */
public class CPUOrEmptyTest
{
    @Test
    public void nonEmpty() {
        Map<String, Long> registers = new CPUAsSafe(
            new CPUOrEmpty(true, "A", 55)
        ).toMap();
        assertFalse(registers.isEmpty());
        assertEquals(new Long(55), registers.get("A"));
    }

    @Test
    public void empty() {
        assertTrue(
            new CPUAsSafe(
                new CPUOrEmpty(false, "B", 0)
            ).toMap().isEmpty()
        );
    }
}