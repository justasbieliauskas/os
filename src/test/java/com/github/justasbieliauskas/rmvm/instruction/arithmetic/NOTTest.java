package com.github.justasbieliauskas.rmvm.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.fake.ChangedRegister;
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