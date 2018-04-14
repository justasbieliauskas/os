package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.IndexEquality;
import com.github.justasbieliauskas.rmvm.refactor.Tests;
import org.junit.Test;

/**
 * Test for {@link RegisterIndex}.
 *
 * @author Justas Bieliauskas
 */
public class RegisterIndexTest
{
    @Test
    public void convertsStringId() {
        new Tests(
            new IndexEquality(new RegisterIndex("A"), 0),
            new IndexEquality(new RegisterIndex("B"), 1),
            new IndexEquality(new RegisterIndex("C"), 2),
            new IndexEquality(new RegisterIndex("D"), 3),
            new IndexEquality(new RegisterIndex("ST"), 4),
            new IndexEquality(new RegisterIndex("IC"), 5),
            new IndexEquality(new RegisterIndex("PI"), 6),
            new IndexEquality(new RegisterIndex("SI"), 7),
            new IndexEquality(new RegisterIndex("TI"), 8),
            new IndexEquality(new RegisterIndex("CS"), 9),
            new IndexEquality(new RegisterIndex("PTR"), 10)
        ).test();
    }
}