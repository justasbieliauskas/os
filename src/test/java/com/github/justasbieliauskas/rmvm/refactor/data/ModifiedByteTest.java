package com.github.justasbieliauskas.rmvm.refactor.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link ModifiedByte}.
 *
 * @author Justas Bieliauskas
 */
public class ModifiedByteTest
{
    @Test
    public void modifiesByte() {
        assertEquals(
            new ModifiedByte(() -> (byte) 50, () -> 3, () -> true).toByte(),
            (byte) 58
        );
    }
}