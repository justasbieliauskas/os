package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Logical predicate evaluated to true or false.
 *
 * @author Justas Bieliauskas
 */
public interface Condition
{
    /**
     * @return true/false value
     */
    boolean isTrue();
}
