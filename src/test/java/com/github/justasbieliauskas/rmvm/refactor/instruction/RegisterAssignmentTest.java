package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.DefaultRegister;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.ChangedRegister;
import org.junit.Test;

/**
 * Test for {@link RegisterAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class RegisterAssignmentTest
{
    @Test
    public void assignsToRegister() {
        new WordEquality(
            new ChangedRegister(
                new DefaultRegister(5),
                new RegisterAssignment(50)
            ),
            50
        ).test();
    }
}