package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
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
        Register a = new Register();
        new WordAssignment(a, () -> 1200).execute();
        assertEquals(a.toInt(), 1200);
    }
}