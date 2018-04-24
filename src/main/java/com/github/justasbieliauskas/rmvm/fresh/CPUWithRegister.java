package com.github.justasbieliauskas.rmvm.fresh;

import com.github.justasbieliauskas.rmvm.data.Word;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;

import java.util.HashMap;
import java.util.Map;

/**
 * Processor with new register value.
 * Chaining object to create/update cpu registers.
 *
 * TODO: document constructors.
 *
 * @author Justas Bieliauskas
 */
public class CPUWithRegister implements CPU
{
    private final CPU processor;

    private final String name;

    private final Word word;

    public CPUWithRegister(String name, Word word) {
        this(() -> new HashMap<>(), name, word);
    }

    public CPUWithRegister(CPU processor, WordWithFlag word) {
        this(processor, "ST", word);
    }

    public CPUWithRegister(CPU processor, String name, Word word) {
        this.processor = processor;
        this.name = name;
        this.word = word;
    }

    @Override
    public Map<String, Integer> toMap() {
        Map<String, Integer> registers = this.processor.toMap();
        registers.put(this.name, this.word.toInt());
        return registers;
    }
}
