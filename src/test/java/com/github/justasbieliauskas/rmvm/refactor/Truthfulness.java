package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Condition;

import static org.junit.Assert.assertTrue;

/**
 * Assertion that something is true.
 *
 * @author Justas Bieliauskas
 */
public class Truthfulness implements Test
{
    private final Condition condition;

    /**
     * @param condition tested condition
     */
    public Truthfulness(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void test() {
        assertTrue(this.condition.isTrue());
    }
}
