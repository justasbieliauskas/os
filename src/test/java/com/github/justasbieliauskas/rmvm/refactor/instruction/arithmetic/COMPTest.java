package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import com.github.justasbieliauskas.rmvm.refactor.data.WordWithFlag;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.ChangedRegister;
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
        new WordEquality(
            new ChangedRegister(
                new COMP(
                    new WordWithFlag(new WordWithFlag('Z', false), 'C', true),
                    5,
                    5
                )
            ),
            new WordWithFlag(new WordWithFlag('Z', true), 'C', false)
        ).test();
    }

    @Test
    public void firstIsLessThanSecond() {
        new WordEquality(
            new ChangedRegister(
                new COMP(
                    new WordWithFlag(new WordWithFlag('Z', true), 'C', false),
                    7,
                    15
                )
            ),
            new WordWithFlag(new WordWithFlag('Z', false), 'C', true)
        ).test();
    }

    @Test
    public void firstIsGreaterThanSecond() {
        new WordEquality(
            new ChangedRegister(
                new COMP(
                    new WordWithFlag(new WordWithFlag('Z', true), 'C', true),
                    21,
                    4
                )
            ),
            new WordWithFlag(new WordWithFlag('Z', false), 'C', false)
        ).test();
    }
}