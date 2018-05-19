package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.EmptyCPU;
import com.github.justasbieliauskas.rmvm.cpu.NewCPU;
import com.github.justasbieliauskas.rmvm.data.*;

import java.util.Map;

/**
 * Processor after ADD instruction.
 *
 * @author Paulius Aleksiūnas
 */
public class CPUAfterADD implements NewCPU
{
    private final CPUAfterArithmetic processor;

    private final Scalar bytes;

    public CPUAfterADD(Scalar bytes) {
        this(new EmptyCPU(), bytes);
    }

    private CPUAfterADD(CPU processor, Scalar bytes) {
        this(
            processor,
            new CPURegister(processor, "A"),
            new CPURegister(processor, "B"),
            bytes
        );
    }

    private CPUAfterADD(CPU processor, CPURegister a, CPURegister b, Scalar bytes) {
        this(
            processor,
            () -> a.toLong() + b.toLong(),
            new WordFlag(a, bytes),
            new WordFlag(b, bytes),
            bytes
        );
    }

    private CPUAfterADD(
        CPU processor,
        Word result,
        WordFlag aFlag,
        WordFlag bFlag,
        Scalar bytes
    ) {
        this(
            processor,
            result,
            new WordInRange(result, bytes),
            aFlag,
            bFlag,
            bytes
        );
    }

    private CPUAfterADD(
        CPU processor,
        Word result,
        WordInRange resultInRange,
        WordFlag aFlag,
        WordFlag bFlag,
        Scalar bytes
    ) {
        this(
            processor,
            result,
            resultInRange,
            aFlag,
            bFlag,
            new WordFlag(resultInRange, bytes),
            bytes
        );
    }

    private CPUAfterADD(
        CPU processor,
        Word result,
        WordInRange resultInRange,
        WordFlag aFlag,
        WordFlag bFlag,
        WordFlag resultInRangeFlag,
        Scalar bytes
    ) {
        this.processor = new CPUAfterArithmetic(
            processor,
            resultInRange,
            new WordWithFlag(
                new WordWithFlag(
                    new WordWithFlag(processor, resultInRange),
                    result,
                    resultInRange
                ),
                'O',
                () -> (aFlag.isTrue() == bFlag.isTrue()) &&
                      (bFlag.isTrue() != resultInRangeFlag.isTrue())
            )
        );
        this.bytes = bytes;
    }


    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }

    @Override
    public NewCPU with(CPU processor) {
        return new CPUAfterADD(processor, this.bytes);
    }
}