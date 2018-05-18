package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.WordEquality;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;
import org.junit.Test;

/**
 * Test for {@link CPUAfterCOMP}.
 *
 * @author Justas Bieliauskas
 * @author Aidas Kvedaravičius
 * @author Linas Jurgelėnas
 */
public class CPUAfterCOMPTest
{
//    @Test
//    public void firstEqualsSecond() {
//        new WordEquality(
//            new CPURegister(
//                new CPUAfterCOMP(
//                    new CPUWithRegister(
//                        new CPUWithRegister(
//                            new CPUWithRegister("A", 5),
//                            "B",
//                            5
//                        ),
//                        new WordWithFlag(
//                            new WordWithFlag('Z', false),
//                            'C',
//                            true
//                        )
//                    )
//                ),
//                "ST"
//            ),
//            new WordWithFlag(
//                new WordWithFlag('Z', true),
//                'C',
//                false
//            )
//        ).test();
//    }
//
//    @Test
//    public void firstIsGreaterThanSecond() {
//        new WordEquality(
//            new CPURegister(
//                new CPUAfterCOMP(
//                    new CPUWithRegister(
//                        new CPUWithRegister(
//                            new CPUWithRegister("A", 10),
//                            "B",
//                            5
//                        ),
//                        new WordWithFlag(
//                            new WordWithFlag('Z', true),
//                            'C',
//                            true
//                        )
//                    )
//                ),
//                "ST"
//            ),
//            new WordWithFlag(
//                new WordWithFlag('Z', false),
//                'C',
//                false
//            )
//        ).test();
//    }
//
//    @Test
//    public void firstIsLessThanSecond() {
//        new WordEquality(
//            new CPURegister(
//                new CPUAfterCOMP(
//                    new CPUWithRegister(
//                        new CPUWithRegister(
//                            new CPUWithRegister("A", 5),
//                            "B",
//                            10
//                        ),
//                        new WordWithFlag(
//                            new WordWithFlag('Z', true),
//                            'C',
//                            false
//                        )
//                    )
//                ),
//                "ST"
//            ),
//            new WordWithFlag(
//                new WordWithFlag('Z', false),
//                'C',
//                true
//            )
//        ).test();
//    }
}