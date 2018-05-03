package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Byte;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that a {@link Byte} equals primitive byte.
 *
 * @author Justas Bieliauskas
 */
public class ByteEquality implements Test
{
    private final Byte subject;

    private final int expected;

    /**
     * @param subject byte subject
     * @param expected expected value
     */
    public ByteEquality(Byte subject, int expected) {
        this.subject = subject;
        this.expected = expected;
    }

    @Override
    public void test() {
        assertEquals(this.expected, this.subject.toByte());
    }
}
