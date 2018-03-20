package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.command.ByteAssignment;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests correct byte assignment.
 *
 * @author Justas Bieliauskas
 */
public class ByteAssignmentTest
{
    @Test
    public void execute() throws Exception {
        FakeByte fake = new FakeByte();
        byte test = (byte) 200;
        new ByteAssignment(fake, new FakeByte(test)).execute();
        assertEquals(fake.value(), test);
    }
}