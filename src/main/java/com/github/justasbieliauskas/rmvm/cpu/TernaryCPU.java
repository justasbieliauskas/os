package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Condition;

import java.util.Map;

/**
 * Processor after ternary operation.
 * Executes first if condition is satisfied, second otherwise.
 *
 * @author Justas Bieliauskas
 */
public class TernaryCPU implements UnsafeCPU
{
    private final Condition condition;

    private final UnsafeCPU processor;

    private final UnsafeCPU alternative;

    /**
     * Constructor for testing.
     *
     * @param condition true/false to toggle first and second
     * @param id identifier of register to change
     * @param processor value on true
     * @param alternative value on false
     */
    TernaryCPU(boolean condition, String id, int processor, int alternative) {
        this(
            () -> condition,
            new CPUWithRegister(id, processor),
            new CPUWithRegister(id, alternative)
        );
    }

    /**
     * Constructor for initializing with safe processors.
     *
     * @param condition whether to act as first or second
     * @param processor safe processor
     * @param alternative safe alternative
     */
    public TernaryCPU(Condition condition, CPU processor, CPU alternative) {
        this(condition, new CPUAsUnsafe(processor), new CPUAsUnsafe(alternative));
    }

    /**
     * Default constructor.
     *
     * @param condition whether to act as processor or alternative
     * @param processor processor if true
     * @param alternative alternative processor id false
     */
    public TernaryCPU(Condition condition, UnsafeCPU processor, UnsafeCPU alternative) {
        this.condition = condition;
        this.processor = processor;
        this.alternative = alternative;
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        Map<String, Long> registers;
        try {
            if(this.condition.isTrue()) {
                registers = this.processor.toMap();
            } else {
                registers = this.alternative.toMap();
            }
        } catch (Exception e) {
            throw new Exception("Failed to convert TernaryCPU to map.", e);
        }
        return registers;
    }
}
