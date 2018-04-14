package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Condition;

import static org.junit.Assert.assertTrue;

/**
 * Assertion of condition being true.
 *
 * @author Justas Bieliauskas
 */
public class Truthfulness implements Test
{
    private final Condition condition;

    /**
     * @param condition condition subject
     */
    public Truthfulness(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void test() {
        assertTrue(this.condition.isTrue());
    }
}
