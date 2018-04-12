package com.github.justasbieliauskas.rmvm.refactor.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link FlagIndex}.
 *
 * @author Justas Bieliauskas
 */
public class FlagIndexTest
{
    @Test
    public void convertsFlagId() {
        assertEquals(new FlagIndex('Z').toInt(), 0);
        assertEquals(new FlagIndex('C').toInt(), 1);
        assertEquals(new FlagIndex('O').toInt(), 2);
        assertEquals(new FlagIndex('D').toInt(), 3);
    }
}