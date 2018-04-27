package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.CPUEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;
import org.junit.Test;

/**
 * Test for {@link CPUAfterADD}.
 *
 * TODO: test overflow
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterADDTest
{
    @Test
    public void addsNormalNumbers() {
        new CPUEquality(
            new CPUAfterADD(88, 127, true, true, true),
            new CPUWithRegister(
                new CPUWithRegister("A", 215),
                new WordWithFlag(
                    new WordWithFlag(
                        new WordWithFlag('Z', false),
                        'C',
                        false
                    ),
                    'O',
                    false
                )
            )
        ).test();
    }

    @Test
    public void resultOutOfRange() {
        new CPUEquality(
            new CPUAfterADD(4294967295L, 3, true, false, true),
            new CPUWithRegister(
                new CPUWithRegister("A", 2),
                new WordWithFlag(
                    new WordWithFlag(
                        new WordWithFlag('Z', false),
                        'C',
                        true
                    ),
                    'O',
                    false
                )
            )
        ).test();
    }

    @Test
    public void addsZeros() {
        new CPUEquality(
            new CPUAfterADD(0, 0, false, true, false),
            new CPUWithRegister(
                new CPUWithRegister("A", 0),
                new WordWithFlag(
                    new WordWithFlag(
                        new WordWithFlag('Z', true),
                        'C',
                        false
                    ),
                    'O',
                    false
                )
            )
        ).test();
    }
}