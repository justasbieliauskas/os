package com.github.justasbieliauskas.rmvm.refactor.data;

import com.github.justasbieliauskas.rmvm.refactor.WordEquality;
import com.github.justasbieliauskas.rmvm.refactor.data.fake.FakeRegister;
import org.junit.Test;

/**
 * Test for {@link ProcessorRegister}.
 *
 * @author Justas Bieliauskas
 */
public class ProcessorRegisterTest
{
    @Test
    public void extractsRegister() {
        new WordEquality(
            new ProcessorRegister(
                new Register[] { new FakeRegister(69), new FakeRegister(420) },
                () -> 1
            ),
            420
        ).test();
    }
}