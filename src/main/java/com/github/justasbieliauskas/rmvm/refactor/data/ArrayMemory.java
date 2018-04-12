package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Memory as array of bytes.
 *
 * @author Justas Bieliauskas
 */
public class ArrayMemory implements Memory
{
    private final byte[] memory;

    /**
     * @param memory array of bytes
     */
    public ArrayMemory(byte[] memory) {
        this.memory = memory;
    }

    @Override
    public void write(int index, byte value) {
        this.memory[index] = value;
    }

    @Override
    public byte byteAt(int index) {
        return this.memory[index];
    }
}
