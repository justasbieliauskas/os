package com.github.justasbieliauskas.rmvm.fresh;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for {@link PostNOTCPU}.
 *
 * @author Justas Bieliauskas
 */
public class PostNOTCPUTest
{
    @Test
    public void invertsNumber() {
        assertEquals(
            new PostNOTCPU(new CPUWithRegister("A", () -> 0)).toMap().get("A"),
            new Integer(-1)
        );
    }
}