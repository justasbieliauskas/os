package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link GeneralPurposeIndex}.
 *
 * @author Justas Bieliauskas
 */
public class GeneralPurposeIndexTest
{
    @Test
    public void convertsCharToRightIndex() {
        assertEquals(new GeneralPurposeIndex('A').toInt(), 0);
        assertEquals(new GeneralPurposeIndex('B').toInt(), 1);
        assertEquals(new GeneralPurposeIndex('C').toInt(), 2);
        assertEquals(new GeneralPurposeIndex('D').toInt(), 3);
    }
}