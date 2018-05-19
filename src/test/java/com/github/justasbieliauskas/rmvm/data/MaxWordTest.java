package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.WordEquality;
import org.junit.Test;

/**
 * Test for {@link MaxWord}.
 *
 * @author Justas Bieliauskas
 */
public class MaxWordTest
{
    @Test
    public void decrementsMax() {
        new WordEquality(
            new MaxWord(() -> 4),
            4294967295L
        ).test();
    }
}