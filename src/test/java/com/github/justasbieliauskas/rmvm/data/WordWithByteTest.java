package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.WordEquality;
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
            new WordWithByte(329697109, 2, (byte) 235),
            334219093
        ).test();
    }
}