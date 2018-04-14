package com.github.justasbieliauskas.rmvm.refactor;

import com.github.justasbieliauskas.rmvm.refactor.data.Byte;

import static org.junit.Assert.assertEquals;

/**
 * Assertion that a {@link Byte} equals primitive byte.
 *
 * @author Justas Bieliauskas
 */
public class ByteEquality implements Test
{
    private final Byte subject;

    private final int value;

    /**
     * @param subject byte subject
     * @param value expected value
     */
    public ByteEquality(Byte subject, int value) {
        this.subject = subject;
        this.value = value;
    }

    @Override
    public void test() {
        assertEquals(this.subject.toByte(), this.value);
    }
}
