package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.ProcessorEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import org.junit.Test;

/**
 * Test for {@link PostDIVCPU}.
 *
 * @author Justas Bieliauskas
 */
public class PostDIVCPUTest
{
    @Test
    public void divides2Numbers() {
        new ProcessorEquality(
            new PostDIVCPU(11, 5, 0),
            new CPUWithRegister(
                "A",
                2
            )
        ).test();
    }
}