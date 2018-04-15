package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.data.fake.FakeRegister;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.NoMemory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link LogicInstruction}.
 *
 * @author Justas Bieliauskas
 */
public class LogicInstructionTest
{
    @Test
    public void works() {
        FakeRegister[] processor = new FakeRegister[] {
            new FakeRegister(),
            new FakeRegister(7)
        };
        new LogicInstruction(
            0, 1, 5, 6,
            new char[] { 'A', 'N', 'D' }
        ).change(processor, new NoMemory());
        assertEquals(processor[0].toInt(), 4);
        assertEquals(processor[1].toInt(), 0);
    }
}