package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.DefaultRegister;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.ChangedRegister;
import org.junit.Test;

/**
 * Test for {@link FlagAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class FlagAssignmentTest
{
    @Test
    public void changesFlagTo1() {
        new WordEquality(
            new ChangedRegister(
                new DefaultRegister(),
                new FlagAssignment(27241, 1, 2, true)
            ),
            28265
        ).test();
    }
}