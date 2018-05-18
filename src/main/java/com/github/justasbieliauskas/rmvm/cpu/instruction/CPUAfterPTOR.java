package com.github.justasbieliauskas.rmvm.cpu.instruction;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import com.github.justasbieliauskas.rmvm.cpu.CPUWithRegister;
import com.github.justasbieliauskas.rmvm.cpu.NewCPUWithId;
import com.github.justasbieliauskas.rmvm.data.CPURegister;
import com.github.justasbieliauskas.rmvm.data.Id;
import com.github.justasbieliauskas.rmvm.data.IdSymbol;

import java.util.HashMap;
import java.util.Map;

/**
 * Processor after PTOR instruction.
 *
 * @author Justas Bieliauskas
 */
public class CPUAfterPTOR implements NewCPUWithId
{
    private final CPUWithRegister processor;

    public CPUAfterPTOR() {
        this(() -> new HashMap<>(), () -> "", () -> "");
    }

    private CPUAfterPTOR(CPU processor, Id p, Id r) {
        this.processor = new CPUWithRegister(
            processor,
            r,
            new CPURegister(processor, p)
        );
    }

    @Override
    public Map<String, Long> toMap() {
        return this.processor.toMap();
    }

    @Override
    public NewCPUWithId with(CPU processor, Id id) {
        return new CPUAfterPTOR(
            processor,
            new IdSymbol(id, 0),
            new IdSymbol(id, 3)
        );
    }
}
