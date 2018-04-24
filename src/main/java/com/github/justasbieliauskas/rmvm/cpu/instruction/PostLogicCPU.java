package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
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

    /**
     * Constructor for testing.
     *
     * @param processor hand-made processor
     * @param result logic operation result as integer
     */
    PostLogicCPU(CPUWithRegister processor, int result) {
        this(processor, () -> result);
    }

    /**
     * Default constructor.
     *
     * @param processor processor
     * @param result logic operation result
     */
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
