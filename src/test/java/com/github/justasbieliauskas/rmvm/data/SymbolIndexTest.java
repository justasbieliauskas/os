package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.IndexEquality;
import org.junit.Test;

/**
 * Test for {@link SymbolIndex}.
 *
 * @author Justas Bieliauskas
 */
public class SymbolIndexTest
{
    @Test
    public void convertsSymbolToIndex() {
        new IndexEquality(
            new SymbolIndex('b', 'a', 'b', 'c'),
            1
        ).test();
    }
}