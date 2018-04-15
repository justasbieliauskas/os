package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.CloneableTests;
import com.github.justasbieliauskas.rmvm.refactor.FlagEquality;
import com.github.justasbieliauskas.rmvm.refactor.TestAsInstruction;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;
import com.github.justasbieliauskas.rmvm.refactor.data.WordWithFlag;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.TestRegister;
import org.junit.Test;

/**
 * Test for {@link COMP}.
 *
 * @author Justas Bieliauskas
 */
public class COMPTest
{
    @Test
    public void numbersAreEqual() {
        new TestAsInstruction(
            new COMP(
                0,
                new WordWithFlag(new WordWithFlag('C', true), 'Z', false),
                5,
                5
            ),
            new Register[] {
                new TestRegister(
                    new CloneableTests(
                        new FlagEquality('Z', true),
                        new FlagEquality('C', false)
                    )
                )
            }
        ).test();
    }

    @Test
    public void firstIsLessThanSecond() {
        new TestAsInstruction(
            new COMP(
                0,
                new WordWithFlag(new WordWithFlag('Z', true), 'C', false),
                7,
                15
            ),
            new Register[] {
                new TestRegister(
                    new CloneableTests(
                        new FlagEquality('Z', false),
                        new FlagEquality('C', true)
                    )
                )
            }
        ).test();
    }

    @Test
    public void firstIsGreaterThanSecond() {
        new TestAsInstruction(
            new COMP(
                0,
                new WordWithFlag(new WordWithFlag('Z', true), 'C', true),
                21,
                4
            ),
            new Register[] {
                new TestRegister(
                    new CloneableTests(
                        new FlagEquality('Z', false),
                        new FlagEquality('C', false)
                    )
                )
            }
        ).test();
    }
}