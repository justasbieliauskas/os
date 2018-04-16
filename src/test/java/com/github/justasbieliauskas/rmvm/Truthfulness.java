package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Condition;

import static org.junit.Assert.assertTrue;

/**
 * Assertion that a condition is true.
 *
 * @author Justas Bieliauskas
 */
public class Truthfulness implements Test
{
    private final Condition condition;

    /**
     * @param condition subject condition
     */
    public Truthfulness(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void test() {
        assertTrue(this.condition.isTrue());
    }
}
