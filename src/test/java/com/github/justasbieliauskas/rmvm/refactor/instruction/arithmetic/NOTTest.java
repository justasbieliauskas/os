package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.ChangedRegister;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.FakeRegister;
import org.junit.Test;

/**
 * Test for {@link NOT}.
 *
 * @author Justas Bieliauskas
 */
public class NOTTest
{
    @Test
    public void negatesWord() {
        new WordEquality(
            new ChangedRegister(new NOT(0)),
            -1
        ).test();
    }
}