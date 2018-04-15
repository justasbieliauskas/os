package com.github.justasbieliauskas.rmvm.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.CloneableTests;
import com.github.justasbieliauskas.rmvm.FlagEquality;
import com.github.justasbieliauskas.rmvm.TestAsInstruction;
import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.fake.FakeRegister;
import com.github.justasbieliauskas.rmvm.data.fake.TestRegister;
import org.junit.Test;

/**
 * Test for {@link LogicInstruction}.
 *
 * @author Justas Bieliauskas
 */
public class LogicInstructionTest
{
    @Test
    public void setsCarryAndOverflow() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 0, 0, 6, new char[] { 'O', 'R' }),
            new Register[] {
                new FakeRegister(),
                new TestRegister(
                    new CloneableTests(
                        new FlagEquality('C', false),
                        new FlagEquality('O', false)
                    )
                )
            }
        ).test();
    }

    @Test
    public void calculatesAND() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 5, 6, 6, new char[] { 'A', 'N', 'D' }),
            new Register[] {
                new TestRegister(new WordEquality(4)),
                new TestRegister(new FlagEquality('Z', false))
            }
        ).test();
    }

    @Test
    public void calculatesZeroAND() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 12, 3, 0, new char[] { 'A', 'N', 'D' }),
            new Register[] {
                new TestRegister(new WordEquality(0)),
                new TestRegister(new FlagEquality('Z', true))
            }
        ).test();
    }

    @Test
    public void calculatesOR() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 7, 2, 1, new char[] { 'O', 'R' }),
            new Register[] {
                new TestRegister(new WordEquality(7)),
                new TestRegister(new FlagEquality('Z', false))
            }
        ).test();
    }

    @Test
    public void calculatesZeroOR() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 0, 0, 0, new char[] { 'O', 'R' }),
            new Register[] {
                new TestRegister(new WordEquality(0)),
                new TestRegister(new FlagEquality('Z', true))
            }
        ).test();
    }

    @Test
    public void calculatesXOR() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 7, 2, 1, new char[] { 'X', 'O', 'R' }),
            new Register[] {
                new TestRegister(new WordEquality(5)),
                new TestRegister(new FlagEquality('Z', false))
            }
        ).test();
    }

    @Test
    public void calculatesZeroXOR() {
        new TestAsInstruction(
            new LogicInstruction(0, 1, 0, 0, 0, new char[] { 'X', 'O', 'R' }),
            new Register[] {
                new TestRegister(new WordEquality(0)),
                new TestRegister(new FlagEquality('Z', true))
            }
        ).test();
    }
}