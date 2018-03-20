package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.command.WordAssignment;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests NOT command.
 */
public class OnesComplimentTest
{
    @Test
    public void value() throws Exception {
        Register A = new Register();
        WordAssignment not = new WordAssignment(
            A,
            new OnesCompliment(() -> 60)
        );
        not.execute();
        assertEquals(A.value(), -61);
    }
}