package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.instruction.PostLogicCPU;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

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
}