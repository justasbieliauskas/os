package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link WordAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class WordAssignmentTest
{
    @Test
    public void assignsWord() throws Exception {
        DefaultRegister a = new DefaultRegister();
        new WordAssignment(a, () -> 1200).execute();
        assertEquals(a.toInt(), 1200);
    }
}