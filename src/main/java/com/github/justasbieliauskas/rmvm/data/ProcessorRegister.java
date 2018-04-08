package com.github.justasbieliauskas.rmvm.data;

/**
 * Nth register in collection of registers (processor).
 *
 * @author Justas Bieliauskas
 */
public class ProcessorRegister implements RegisterInterface
{
    private final RegisterInterface[] registers;

    private final RWord index;

    /**
     * @param registers all registers
     * @param id general purpose register identifier as symbol
     */
    public ProcessorRegister(RegisterInterface[] registers, char id) {
        this(registers, (byte) id);
    }

    /**
     * @param registers all registers
     * @param id general purpose register identifier as byte value
     */
    public ProcessorRegister(RegisterInterface[] registers, byte id) {
        this(registers, new GeneralPurposeIndex(id));
    }

    /**
     * @param registers all register
     * @param id other register identifier
     */
    public ProcessorRegister(RegisterInterface[] registers, String id) {
        this(registers, new OtherRegisterIndex(id));
    }

    /**
     * @param registers all registers
     * @param index register index
     */
    public ProcessorRegister(RegisterInterface[] registers, RWord index) {
        this.registers = registers;
        this.index = index;
    }

    @Override
    public int toInt() {
        return this.registers[this.index.toInt()].toInt();
    }

    @Override
    public void assign(int value) {
        this.registers[this.index.toInt()].assign(value);
    }
}
