package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.FlagIndex;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that certain flag is true or false.
 * For possible flag identifiers, see {@link FlagIndex}.
 *
 * @author Justas Bieliauskas
 */
public class FlagEquality implements CloneableTest
{
    private final Condition flag;

    private final FlagIndex index;

    private final boolean expected;

    /**
     * @param id flag id
     * @param expected expected value
     */
    public FlagEquality(char id, boolean expected) {
        this(0, new FlagIndex(id), expected);
    }

    private FlagEquality(int value, FlagIndex index, boolean expected) {
        this.flag = () -> ((value >> index.toInt()) & 1) == 1;
        this.index = index;
        this.expected = expected;
    }

    @Override
    public void test() {
        assertEquals(this.flag.isTrue(), this.expected);
    }

    @Override
    public CloneableTest with(int value) {
        return new FlagEquality(value, this.index, this.expected);
    }
}
