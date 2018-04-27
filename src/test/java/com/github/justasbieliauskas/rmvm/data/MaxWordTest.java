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
            new MaxWord(-5),
            4294967290L
        ).test();
    }
}