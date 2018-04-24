package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Word;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;

import java.util.HashMap;
import java.util.Map;

/**
 * Processor with new register value added.
 *
 * @author Justas Bieliauskas
 */
public class CPUWithRegister implements CPU
{
    private final CPU processor;

    private final String id;

    private final Word word;

    /**
     * Constructor for creating initial processor with new value as integer.
     *
     * @param id register identifier
     * @param word register value as integer
     */
    public CPUWithRegister(String id, int word) {
        this(id, () -> word);
    }

    /**
     * Constructor for creating initial processor with id + value.
     *
     * @param id register identifier
     * @param word register value
     */
    public CPUWithRegister(String id, Word word) {
        this(() -> new HashMap<>(), id, word);
    }

    /**
     * Same as default, but new value passed as integer.
     * Used in testing.
     *
     * @param processor processor
     * @param id register identifier
     * @param word new register value as integer
     */
    public CPUWithRegister(CPU processor, String id, int word) {
        this(processor, id, () -> word);
    }

    /**
     * Constructor for changing status register in processor.
     *
     * @param processor processor
     * @param word new status register value
     */
    public CPUWithRegister(CPU processor, WordWithFlag word) {
        this(processor, "ST", word);
    }

    /**
     * Default constructor.
     * Chains previous processor with new id + value.
     *
     * @param processor processor
     * @param id register identifier
     * @param word new register value
     */
    public CPUWithRegister(CPU processor, String id, Word word) {
        this.processor = processor;
        this.id = id;
        this.word = word;
    }

    @Override
    public Map<String, Integer> toMap() {
        Map<String, Integer> registers = this.processor.toMap();
        registers.put(this.id, this.word.toInt());
        return registers;
    }
}
