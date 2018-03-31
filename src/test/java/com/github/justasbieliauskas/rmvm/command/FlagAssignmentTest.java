package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.FakeWord;
import com.github.justasbieliauskas.rmvm.data.Register;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link FlagAssignment}
 *
 * @author Justas Bieliauskas
 */
public class FlagAssignmentTest
{
    @Test
    public void changesThirdFlagTo0() throws Exception {
        Register status = new Register(7);
        new FlagAssignment(status, 0, 2, () -> false).execute();
        assertEquals(status.toInt(), 3);
    }
}