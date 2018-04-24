package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.CachedCPU;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.SymbolIndex;
import com.github.justasbieliauskas.rmvm.data.Word;
import com.github.justasbieliauskas.rmvm.data.WordWithFlag;

import java.util.Map;

/**
 * Processor after logic instruction - AND, OR, XOR.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterLogic implements CPU
{
    private final CPUWithRegister processor;

    /**
     * Constructor for testing.
     *
     * @param processor hand-made processor
     * @param result logic operation result as integer
     */
    CPUAfterLogic(CPUWithRegister processor, int result) {
        this(processor, () -> result);
    }

    /**
     * Default constructor.
     *
     * @param processor processor
     * @param name operation name - "AND", "OR" or "XOR"
     */
    public CPUAfterLogic(CPU processor, char[] name) {
        this(new CachedCPU(processor), name);
    }

    private CPUAfterLogic(CachedCPU processor, char[] name) {
        this(
            processor,
            new SymbolIndex(name[0], 'A', 'O', 'X'),
            new CPURegister(processor, "A"),
            new CPURegister(processor, "B")
        );
    }

    private CPUAfterLogic(
        CPU processor,
        SymbolIndex index,
        CPURegister first,
        CPURegister second
    ) {
        this(
            processor,
            index,
            () -> first.toInt() & second.toInt(),
            () -> first.toInt() | second.toInt(),
            () -> first.toInt() ^ second.toInt()
        );
    }

    private CPUAfterLogic(CPU processor, SymbolIndex index, Word... results) {
        this(
            processor,
            () -> results[index.toInt()].toInt()
        );
    }

    private CPUAfterLogic(CPU processor, Word result) {
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
