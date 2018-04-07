package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link HexAddress}.
 *
 * @author Justas Bieliauskas
 */
public class HexAddressTest
{
    @Test
    public void hexToDec() {
        assertEquals(
            new HexAddress('B', '6').toInt(),
            182
        );
    }
}