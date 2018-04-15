package com.github.justasbieliauskas.rmvm.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.TestAsInstruction;
import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.fake.TestRegister;
import com.github.justasbieliauskas.rmvm.data.fake.UnchangeableRegister;
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
        new TestAsInstruction(
            new DIV(0, 5, 3, 1),
            new Register[] {
                new TestRegister(new WordEquality(1)),
                new UnchangeableRegister("status")
            }
        ).test();
    }

    @Test
    public void dividesNumberBy0() {
        new TestAsInstruction(
            new DIV(0, 2, 0, 1),
            new Register[] {
                new UnchangeableRegister("division result"),
                new TestRegister(new WordEquality(2))
            }
        ).test();
    }
}