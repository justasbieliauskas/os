package com.github.justasbieliauskas.rmvm.refactor.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link ModifiedWord}.
 *
 * @author Justas Bieliauskas
 */
public class ModifiedWordTest
{
    @Test
    public void modifiesWord() {
        assertEquals(
            new ModifiedWord(() -> 728768571, 2, () -> (byte) 7).toInt(),
            721887291
        );
    }
}