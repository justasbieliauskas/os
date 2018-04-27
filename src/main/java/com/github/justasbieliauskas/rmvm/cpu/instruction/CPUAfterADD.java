package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.*;

import java.util.Map;

/**
 * Processor after ADD instruction.
 *
 * @author Paulius Aleksiūnas
 */
public class CPUAfterADD implements CPU
{
    private final CPUWithRegister processor;

    /**
     * Constructor for testing.
     *
     * @param a A register value
     * @param b B register value
     * @param zero zero flag as boolean
     * @param carry carry flag as boolean
     * @param overflow overflow flag as boolean
     */
    CPUAfterADD(long a, long b, boolean zero, boolean carry, boolean overflow) {
        this(
            new CPUWithRegister(
                new CPUWithRegister(
                    new CPUWithRegister("A", a),
                    "B",
                    b
                ),
                new WordWithFlag(
                    new WordWithFlag(
                        new WordWithFlag('Z', zero),
                        'C',
                        carry
                    ),
                    'O',
                    overflow
                )
            )
        );
    }

    /**
     * Default constructor.
     *
     * @param processor processor
     */
    public CPUAfterADD(CPU processor) {
        this(
            processor,
            new CPURegister(processor, "A"),
            new CPURegister(processor, "B")
        );
    }

    private CPUAfterADD(CPU processor, CPURegister a, CPURegister b) {
        this(
            processor,
            () -> a.toLong() + b.toLong(),
            // FIXME: shouldn't be aware of word limit
            () -> a.toLong() > 268435455,
            () -> b.toLong() > 268435455
        );
    }

    private CPUAfterADD(CPU processor, Word result, Condition aFlag, Condition bFlag) {
        this(processor, result, new WordInRange(result), aFlag, bFlag);
    }

    private CPUAfterADD(
        CPU processor,
        Word result,
        WordInRange resultInRange,
        Condition aFlag,
        Condition bFlag
    ) {
        this.processor = new CPUWithRegister(
            new CPUWithRegister(processor, "A", resultInRange),
            new WordWithFlag(
                new WordWithFlag(
                    new WordWithFlag(processor, resultInRange),
                    result,
                    resultInRange
                ),
                'O',
                () -> {
                    if(aFlag.isTrue() != bFlag.isTrue()) {
                        return false;
                    }
                    boolean resultFlag = resultInRange.toLong() > 268435455;
                    return bFlag.isTrue() != resultFlag;
                }
            )
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }
}