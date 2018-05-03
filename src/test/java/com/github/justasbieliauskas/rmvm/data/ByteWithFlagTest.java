package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.ByteEquality;
import org.junit.Test;

/**
 * Test for {@link ByteWithFlag}.
 *
 * @author Justas Bieliauskas
 */
public class ByteWithFlagTest
{
    @Test
    public void modifiesFlag() {
        new ByteEquality(
            new ByteWithFlag((byte) 87, 1, false),
            (byte) 85
        ).test();
    }
}