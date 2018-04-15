package com.github.justasbieliauskas.rmvm.refactor;

/**
 * Test with additional ability to clone itself with new parameter.
 * Used in testing instructions to test new values on register change.
 *
 * @author Justas Bieliauskas
 */
public interface CloneableTest extends Test
{
    /**
     * Creates a new test with new value.
     *
     * @param value new value
     * @return test case
     */
    CloneableTest with(int value);
}
