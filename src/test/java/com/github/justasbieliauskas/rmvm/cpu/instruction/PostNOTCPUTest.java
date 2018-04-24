package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import org.junit.Test;

/**
 * Test for {@link PostNOTCPU}.
 *
 * @author Justas Bieliauskas
 */
public class PostNOTCPUTest
{
    @Test
    public void invertsNumber() {
        new WordEquality(
            new CPURegister(
                new PostNOTCPU(new CPUWithRegister("A", 0)),
                "A"
            ),
            -1
        ).test();
    }
}