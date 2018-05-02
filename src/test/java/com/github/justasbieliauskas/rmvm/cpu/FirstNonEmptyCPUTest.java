package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link FirstNonEmptyCPU}.
 *
 * @author Justas Bieliauskas
 */
public class FirstNonEmptyCPUTest
{
    @Test
    public void fetchesFirstNonEmpty() {
        new WordEquality(
            new CPURegister(
                new FirstNonEmptyCPU(
                    new CPUOrEmpty(false, "A", 48),
                    new CPUOrEmpty(true, "A", 89),
                    new CPUOrEmpty(true, "A", 900)
                ),
                "A"
            ),
            89
        ).test();
    }

    @Test
    public void empty() {
        // TODO: oop test
        assertTrue(
            new CPUAsSafe(
                new FirstNonEmptyCPU(
                    new CPUOrEmpty(false, "C", 4),
                    new CPUOrEmpty(false, "D", 5556)
                )
            ).toMap().isEmpty()
        );
    }
}