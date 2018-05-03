package com.github.justasbieliauskas.rmvm.cpu;

import java.util.HashMap;
import java.util.Map;

import com.github.justasbieliauskas.rmvm.data.LongRegister;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Processor using {@link Register} variables.
 *
 * @author Justas Bieliauskas
 */
public class CPUOfRegisters implements MutableCPU
{
    private final Register[] registers;

    /**
     * Constructor for initializing with default {@link LongRegister}.
     */
    public CPUOfRegisters() {
        this(
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister(),
            new LongRegister()
        );
    }

    /**
     * Default constructor.
     *
     * @param a general purpose (A) register
     * @param b general purpose (B) register
     * @param c general purpose (C) register
     * @param d general purpose (D) register
     * @param status status (ST) register
     * @param counter instruction counter (IC) register
     * @param supervisor register for supervisor interrupts (SI)
     * @param error register for programming error interrupts (PI)
     * @param timer register for timer interrupts (TI)
     * @param code code segment (CS) register
     * @param page register for virtual memory page address (PTR)
     */
    public CPUOfRegisters(
        Register a,
        Register b,
        Register c,
        Register d,
        Register status,
        Register counter,
        Register supervisor,
        Register error,
        Register timer,
        Register code,
        Register page
    ) {
        this.registers = new Register[] {
            a,
            b,
            c,
            d,
            status,
            counter,
            supervisor,
            error,
            timer,
            code,
            page
        };
    }

    @Override
    public Map<String, Long> toMap() {
        HashMap<String, Long> registers = new HashMap<>();
        registers.put("A", this.registers[0].toLong());
        registers.put("B", this.registers[1].toLong());
        registers.put("C", this.registers[2].toLong());
        registers.put("D", this.registers[3].toLong());
        registers.put("ST", this.registers[4].toLong());
        registers.put("IC", this.registers[5].toLong());
        registers.put("SI", this.registers[6].toLong());
        registers.put("PI", this.registers[7].toLong());
        registers.put("TI", this.registers[8].toLong());
        registers.put("CS", this.registers[9].toLong());
        registers.put("PTR", this.registers[10].toLong());
        return registers;
    }

    @Override
    public void update(Map<String, Long> registers) {
        this.registers[0].change(registers.get("A"));
        this.registers[1].change(registers.get("B"));
        this.registers[2].change(registers.get("C"));
        this.registers[3].change(registers.get("D"));
        this.registers[4].change(registers.get("ST"));
        this.registers[5].change(registers.get("IC"));
        this.registers[6].change(registers.get("SI"));
        this.registers[7].change(registers.get("PI"));
        this.registers[8].change(registers.get("TI"));
        this.registers[9].change(registers.get("CS"));
        this.registers[10].change(registers.get("PTR"));
    }
}
