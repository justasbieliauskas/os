package com.github.justasbieliauskas.rmvm.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.data.fake.ChangedRegister;
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
            new ChangedRegister(new RegisterAssignment(50)),
            50
        ).test();
    }
}