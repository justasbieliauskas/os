package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.TestAsInstruction;
import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.TestRegister;
import org.junit.Test;

/**
 * Test for {@link Instructions}.
 *
 * @author Justas Bieliauskas
 */
public class InstructionsTest
{
    @Test
    public void assignsTwoNumbers() {
        new TestAsInstruction(
            new Instructions(
                new RegisterAssignment(() -> 0, 44),
                new RegisterAssignment(() -> 1, 45)
            ),
            new Register[] {
                new TestRegister(new WordEquality(44)),
                new TestRegister(new WordEquality(45))
            }
        ).test();
    }
}