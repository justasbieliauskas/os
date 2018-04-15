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
    public void modifiesByte() {
        new ByteEquality(
            new ByteWithFlag(() -> (byte) 50, () -> 3, () -> true),
            (byte) 58
        ).test();
    }
}