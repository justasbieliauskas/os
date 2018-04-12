package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.ArrayMemory;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test for {@link MemoryAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class MemoryAssignmentTest
{
    @Test
    public void assignsBytesToMemory() {
        ArrayMemory memory = new ArrayMemory(new byte[5]);
        new MemoryAssignment(
            () -> 2,
            Arrays.asList(() -> (byte) 72, () -> (byte) 105)
        ).change(new Register[]{}, memory);
        assertEquals(memory.byteAt(2), (byte) 72);
        assertEquals(memory.byteAt(3), (byte) 105);
    }
}