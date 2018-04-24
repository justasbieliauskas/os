package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;
import org.junit.Test;

/**
 * Test for {@link PostLogicCPU}.
 *
 * @author Justas Bieliauskas
 */
public class PostLogicCPUTest
{
    @Test
    public void changesFlagsForNonZero() {
        new WordEquality(
            new CPURegister(
                new PostLogicCPU(
                    new CPUWithRegister(
                        new WordWithFlag(
                            new WordWithFlag(
                                new WordWithFlag('Z', true),
                                'C',
                                true
                            ),
                            'O',
                            true
                        )
                    ),
                    55
                ),
                "ST"
            ),
            new WordWithFlag(
                new WordWithFlag(
                    new WordWithFlag('Z', false),
                    'C',
                    false
                ),
                'O',
                false
            )
        ).test();
    }

    @Test
    public void changesFlagsForZero() {
        new WordEquality(
            new CPURegister(
                new PostLogicCPU(
                    new CPUWithRegister(
                        new WordWithFlag(
                            new WordWithFlag(
                                new WordWithFlag('Z', false),
                                'C',
                                false
                            ),
                            'O',
                            false
                        )
                    ),
                    0
                ),
                "ST"
            ),
            new WordWithFlag(
                new WordWithFlag(
                    new WordWithFlag('Z', true),
                    'C',
                    false
                ),
                'O',
                false
            )
        ).test();
    }

    @Test
    public void calculatesAND() {
        new WordEquality(
            new CPURegister(
                new PostLogicCPU(
                    new CPUWithRegister(
                        new CPUWithRegister(
                            new CPUWithRegister("ST", 0),
                            "A",
                            6
                        ),
                        "B",
                        12
                    ),
                    new char[] {'A', 'N', 'D'}
                ),
                "A"
            ),
            4
        ).test();
    }

    @Test
    public void calculatesOR() {
        new WordEquality(
            new CPURegister(
                new PostLogicCPU(
                    new CPUWithRegister(
                        new CPUWithRegister(
                            new CPUWithRegister("ST", 0),
                            "A",
                            13
                        ),
                        "B",
                        8
                    ),
                    new char[] {'O', 'R'}
                ),
                "A"
            ),
            13
        ).test();
    }

    @Test
    public void calculatesXOR() {
        new WordEquality(
            new CPURegister(
                new PostLogicCPU(
                    new CPUWithRegister(
                        new CPUWithRegister(
                            new CPUWithRegister("ST", 0),
                            "A",
                            21
                        ),
                        "B",
                        26
                    ),
                    new char[] {'X', 'O', 'R'}
                ),
                "A"
            ),
            15
        ).test();
    }
}