package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link CPUIfIdMatches}.
 *
 * @author Justas Bieliauskas
 */
public class CPUIfIdMatchesTest
{
    @Test
    public void matches() {
        new WordEquality(
            new CPURegister(
                new CPUIfIdMatches("id", "id", "A", 144),
                "A"
            ),
            144
        ).test();
    }

    @Test
    public void doesNotMatch() {
        assertTrue(
            new CPUAsSafe(
                new CPUIfIdMatches("other", "id", "B", 888)
            ).toMap().isEmpty()
        );
    }
}