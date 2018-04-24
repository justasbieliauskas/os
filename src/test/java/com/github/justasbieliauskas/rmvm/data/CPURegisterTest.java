package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import org.junit.Test;

/**
 * Test for {@link CPURegister}.
 *
 * @author Justas Bieliauskas
 */
public class CPURegisterTest
{
    @Test
    public void extractsRegisterValue() {
        new WordEquality(
            new CPURegister(
                new CPUWithRegister("PTR", 5),
                "PTR"
            ),
            5
        ).test();
    }
}