package com.github.justasbieliauskas.rmvm.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.FlagEquality;
import com.github.justasbieliauskas.rmvm.TestAsInstruction;
import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;
import com.github.justasbieliauskas.rmvm.data.fake.FakeRegister;
import com.github.justasbieliauskas.rmvm.data.fake.TestRegister;
import org.junit.Test;

/**
 * Test for {@link LShift}.
 *
 * @author Justas Bieliauskas
 */
public class LShiftTest
{
    @Test
    public void shifts() {
        new TestAsInstruction(
            new LShift(13, 3, new WordWithFlag('C', false)),
            new Register[] {
                new TestRegister(new WordEquality(104)),
                new FakeRegister()
            }
        ).test();
    }

    @Test
    public void shiftsToNonZero() {
        new TestAsInstruction(
            new LShift(10, 4, new WordWithFlag('Z', true)),
            new Register[] {
                new FakeRegister(),
                new TestRegister(new FlagEquality('Z', false))
            }
        ).test();
    }

    @Test
    public void shiftsToZero() {
        new TestAsInstruction(
            new LShift(1073741824, 2, new WordWithFlag('Z', false)),
            new Register[] {
                new TestRegister(new WordEquality(0)),
                new TestRegister(new FlagEquality('Z', true))
            }
        ).test();
    }

    @Test
    public void shifts0ToCarry() {
        new TestAsInstruction(
            new LShift(11, 3, new WordWithFlag('C', true)),
            new Register[] {
                new FakeRegister(),
                new TestRegister(new FlagEquality('C', false))
            }
        ).test();
    }

    @Test
    public void shifts1ToCarry() {
        new TestAsInstruction(
            new LShift(268435456, 4, new WordWithFlag('C', false)),
            new Register[] {
                new FakeRegister(),
                new TestRegister(new FlagEquality('C', true))
            }
        ).test();
    }

    @Test
    public void shiftsMultipleTimesWithOverflow0() {
        new TestAsInstruction(
            new LShift(55, 4, new WordWithFlag('O', false)),
            new Register[] {
                new FakeRegister(),
                new TestRegister(new FlagEquality('O', false))
            }
        ).test();
    }

    @Test
    public void shiftsMultipleTimesWithOverflow1() {
        new TestAsInstruction(
            new LShift(155, 6, new WordWithFlag('O', true)),
            new Register[] {
                new FakeRegister(),
                new TestRegister(new FlagEquality('O', true))
            }
        ).test();
    }

    @Test
    public void shiftsOnceWithDifferentMSB() {
        new TestAsInstruction(
            new LShift(1342177280, 1, new WordWithFlag('O', false)),
            new Register[] {
                new FakeRegister(),
                new TestRegister(new FlagEquality('O', true))
            }
        ).test();
    }
}