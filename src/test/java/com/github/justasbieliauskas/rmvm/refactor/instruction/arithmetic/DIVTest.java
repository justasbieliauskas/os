package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.InstructionAsTest;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.EqualityRegister;
import org.junit.Test;

/**
 * Test for {@link DIV}.
 *
 * @author Justas Bieliauskas
 */
public class DIVTest
{
    @Test
    public void dividesNumberByNumber() {
        new InstructionAsTest(
            new DIV(0, 1, 5, 3),
            new EqualityRegister[] {
                new EqualityRegister(1),
                new EqualityRegister(0)
            }
        ).test();
    }

    @Test
    public void dividesNumberBy0() {
        new InstructionAsTest(
            new DIV(0, 1, 2, 0),
            new EqualityRegister[] {
                new EqualityRegister(0),
                new EqualityRegister(2)
            }
        ).test();
    }
}