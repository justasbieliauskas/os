package com.github.justasbieliauskas.rmvm;

/**
 * Test with additional ability to clone itself with new parameter.
 * Used in testing instructions to test new values on register change.
 *
 * @author Justas Bieliauskas
 */
public interface CloneableTest extends Test
{
    /**
     * Clones itself with new value.
     *
     * @param value new value
     * @return test
     */
    CloneableTest with(int value);
}
