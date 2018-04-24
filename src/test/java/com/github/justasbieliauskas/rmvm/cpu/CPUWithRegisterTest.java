package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.ProcessorEquality;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Test for {@link CPUWithRegister}.
 *
 * @author Justas Bieliauskas
 */
public class CPUWithRegisterTest
{
    @Test
    public void twoRegisterCPUsAreEqual() {
        new ProcessorEquality(
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