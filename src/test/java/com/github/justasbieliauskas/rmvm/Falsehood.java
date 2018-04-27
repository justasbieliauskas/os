package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Condition;

import static org.junit.Assert.assertFalse;

/**
 * Assertion that condition is false.
 *
 * @author Justas Bieliauskas
 */
public class Falsehood implements Test
{
    private final Condition condition;

    /**
     * @param condition subject condition
     */
    public Falsehood(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void test() {
        assertFalse(this.condition.isTrue());
    }
}
