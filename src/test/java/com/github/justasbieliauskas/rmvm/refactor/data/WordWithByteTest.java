package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import org.junit.Test;

/**
 * Test for {@link WordWithByte}.
 *
 * @author Justas Bieliauskas
 */
public class WordWithByteTest
{
    @Test
    public void modifiesWord() {
        new WordEquality(
            new WordWithByte(() -> 728768571, 2, () -> (byte) 7),
            721887291
        ).test();
    }
}