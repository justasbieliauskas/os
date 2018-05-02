package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.TernaryCPU;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import org.junit.Test;

/**
 * Test for {@link TernaryCPU}.
 *
 * @author Justas Bieliauskas
 */
public class TernaryCPUTest
{
    @Test
    public void onTrue() {
        new WordEquality(
            new CPURegister(
                new TernaryCPU(true, "A", 5, 14),
                "A"
            ),
            5
        ).test();
    }

    @Test
    public void onFalse() {
        new WordEquality(
            new CPURegister(
                new TernaryCPU(false, "A", 66, 28),
                "A"
            ),
            28
        ).test();
    }
}