package com.github.justasbieliauskas.rmvm.fresh;

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