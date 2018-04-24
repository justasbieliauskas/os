package com.github.justasbieliauskas.rmvm.fresh;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Test for {@link CPUWithRegister}.
 *
 * @author Justas Bieliauskas
 */
public class CPUWithRegisterTest
{
    @Test
    public void constructsTwoRegisters() {
        CPUWithRegister processor = new CPUWithRegister(
            new CPUWithRegister("A", () -> 1),
            "B",
            () -> 2
        );
        Map<String, Integer> registers = processor.toMap();
        assertEquals(registers.get("A"), new Integer(1));
        assertEquals(registers.get("B"), new Integer(2));
    }

    @Test
    public void setsSameRegister() {
        CPUWithRegister processor = new CPUWithRegister(
            new CPUWithRegister("A", () -> 1),
            "A",
            () -> 2
        );
        Map<String, Integer> registers = processor.toMap();
        assertEquals(registers.get("A"), new Integer(2));
    }
}