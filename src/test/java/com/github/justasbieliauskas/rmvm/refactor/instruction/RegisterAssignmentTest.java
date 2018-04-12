package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.DefaultRegister;
import com.github.justasbieliauskas.rmvm.refactor.data.NoMemory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link RegisterAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class RegisterAssignmentTest
{
    @Test
    public void assignsToRegister() {
        DefaultRegister[] processor = new DefaultRegister[] { new DefaultRegister(5) };
        new RegisterAssignment(0, 50).change(processor, new NoMemory());
        assertEquals(processor[0].toInt(), 50);
    }
}