package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.data.Condition;

import java.util.Map;

/**
 * Processor after ternary operation.
 * Executes first if condition is satisfied, second otherwise.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterTernary implements CPU
{
    private final Condition condition;

    private final CPU first;

    private final CPU second;

    /**
     * Constructor for testing.
     *
     * @param condition true/false to toggle first and second
     * @param id identifier of register to change
     * @param first value on true
     * @param second value on false
     */
    CPUAfterTernary(boolean condition, String id, int first, int second) {
        this(
            () -> condition,
            new CPUWithRegister(id, first),
            new CPUWithRegister(id, second)
        );
    }

    /**
     * Default constructor.
     *
     * @param condition whether to act as first or second
     * @param first processor on true
     * @param second processor on false
     */
    public CPUAfterTernary(Condition condition, CPU first, CPU second) {
        this.condition = condition;
        this.first = first;
        this.second = second;
    }

    @Override
    public Map<String, Integer> toMap() {
        if(this.condition.isTrue()) {
            return this.first.toMap();
        }
        return this.second.toMap();
    }
}
