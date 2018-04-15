package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.IndexEquality;
import com.github.justasbieliauskas.rmvm.Tests;
import org.junit.Test;

/**
 * Test for {@link FlagIndex}.
 *
 * @author Justas Bieliauskas
 */
public class FlagIndexTest
{
    @Test
    public void convertsFlagId() {
        new Tests(
            new IndexEquality(new FlagIndex('Z'), 0),
            new IndexEquality(new FlagIndex('C'), 1),
            new IndexEquality(new FlagIndex('O'), 2),
            new IndexEquality(new FlagIndex('D'), 3)
        ).test();
    }
}