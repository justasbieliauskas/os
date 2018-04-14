package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Condition;

import static org.junit.Assert.assertFalse;

/**
 * Assertion of condition being false.
 *
 * @author Justas Bieliauskas
 */
public class Falsehood implements Test
{
    private final Condition condition;

    /**
     * @param condition condition subject
     */
    public Falsehood(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void test() {
        assertFalse(this.condition.isTrue());
    }
}
