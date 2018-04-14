package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import org.junit.Test;

/**
 * Test for {@link ModifiedWord}.
 *
 * @author Justas Bieliauskas
 */
public class ModifiedWordTest
{
    @Test
    public void modifiesWord() {
        new WordEquality(
            new ModifiedWord(() -> 728768571, 2, () -> (byte) 7),
            721887291
        ).test();
    }
}