package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.DefaultRegister;
import com.github.justasbieliauskas.rmvm.refactor.data.NoMemory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link FlagAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class FlagAssignmentTest
{
    @Test
    public void changesFlagTo1() {
        DefaultRegister[] processor = new DefaultRegister[] { new DefaultRegister(27241) };
        new FlagAssignment(
            processor[0],
            () -> 0,
            1,
            () -> 2,
            () -> true
        ).change(processor, new NoMemory());
        assertEquals(processor[0].toInt(), 28265);
    }
}