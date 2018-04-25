package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import org.junit.Test;

/**
 * Test for {@link CPUAfterSUB}.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterSUBTest
{
    @Test
    public void subtractsBFromA() {
        new WordEquality(
            new CPURegister(
                new CPUAfterSUB(
                    new CPUWithRegister(
                        new CPUWithRegister(
                            new CPUWithRegister("ST", 0),
                            "A",
                            7
                        ),
                        "B",
                        38
                    )
                ),
                "A"
            ),
            -31
        ).test();
    }
}