package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link InstructionAddress}.
 *
 * @author Justas Bieliauskas
 */
public class InstructionAddressTest
{
    @Test
    public void calculatesAddress() {
        assertEquals(
            new InstructionAddress(new DefaultRegister(112), () -> 28).toInt(),
            224
        );
    }
}