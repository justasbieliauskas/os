package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.instruction.PostLogicCPU;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Test for {@link PostLogicCPU}.
 *
 * @author Justas Bieliauskas
 */
public class PostLogicCPUTest
{
    @Test
    public void works() {
        HashMap<String, Integer> registers = new HashMap<>();
        registers.put("ST", 6);
        assertEquals(
            new PostLogicCPU(() -> registers, () -> 0).toMap().get("ST"),
            new Integer(1)
        );
    }
}