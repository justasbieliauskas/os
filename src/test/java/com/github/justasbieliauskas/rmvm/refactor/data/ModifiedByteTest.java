package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.ByteEquality;
import org.junit.Test;

/**
 * Test for {@link ModifiedByte}.
 *
 * @author Justas Bieliauskas
 */
public class ModifiedByteTest
{
    @Test
    public void modifiesByte() {
        new ByteEquality(
            new ModifiedByte(() -> (byte) 50, () -> 3, () -> true),
            (byte) 58
        ).test();
    }
}