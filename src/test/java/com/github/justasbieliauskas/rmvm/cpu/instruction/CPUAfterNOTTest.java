package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import org.junit.Test;

/**
 * Test for {@link CPUAfterNOT}.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterNOTTest
{
    @Test
    public void invertsNumber() {
        new WordEquality(
            new CPURegister(
                new CPUAfterNOT(new CPUWithRegister("A", 0)),
                "A"
            ),
            -1
        ).test();
    }
}