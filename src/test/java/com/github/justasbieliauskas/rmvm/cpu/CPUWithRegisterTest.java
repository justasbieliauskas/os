package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.CPUEquality;
import org.junit.Test;

/**
 * Test for {@link CPUWithRegister}.
 *
 * @author Justas Bieliauskas
 */
public class CPUWithRegisterTest
{
    @Test
    public void twoRegisterCPUsAreEqual() {
        new CPUEquality(
            new CPUWithRegister(
                new CPUWithRegister("A", () -> 1),
                "B",
                () -> 2
            ),
            new CPUWithRegister(
                new CPUWithRegister("A", () -> 1),
                "B",
                () -> 2
            )
        ).test();
    }
}