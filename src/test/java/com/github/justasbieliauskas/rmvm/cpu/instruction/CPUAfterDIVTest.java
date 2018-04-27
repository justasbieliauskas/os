package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.CPUEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import org.junit.Test;

/**
 * Test for {@link CPUAfterDIV}.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterDIVTest
{
    @Test
    public void divides2Numbers() {
        new CPUEquality(
            new CPUAfterDIV(11, 5, 0),
            new CPUWithRegister(
                "A",
                2
            )
        ).test();
    }
}