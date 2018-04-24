package com.github.justasbieliauskas.rmvm.fresh;

import com.github.justasbieliauskas.rmvm.data.Word;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;

import java.util.Map;

/**
 * Processor after logic instruction - AND, OR, XOR.
 *
 * @author Justas Bieliauskas
 */
public class PostLogicCPU implements CPU
{
    private final CPUWithRegister processor;

    public PostLogicCPU(CPU processor, Word result) {
        this.processor = new CPUWithRegister(
            new CPUWithRegister(processor, "A", result),
            new WordWithFlag(
                new WordWithFlag(
                    new WordWithFlag(processor, result),
                    'C',
                    false
                ),
                'O',
                false
            )
        );
    }

    @Override
    public Map<String, Integer> toMap() {
        return this.processor.toMap();
    }
}
