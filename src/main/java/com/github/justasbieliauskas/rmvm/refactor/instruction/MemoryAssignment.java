package com.github.justasbieliauskas.rmvm.refactor.instruction;

import com.github.justasbieliauskas.rmvm.refactor.data.Byte;
import com.github.justasbieliauskas.rmvm.refactor.data.Index;
import com.github.justasbieliauskas.rmvm.refactor.data.Memory;
import com.github.justasbieliauskas.rmvm.refactor.data.Register;

/**
 * Assigning of bytes to memory.
 *
 * @author Justas Bieliauskas
 */
public class MemoryAssignment implements Instruction
{
    private final Index index;

    private final Iterable<Byte> bytes;

    /**
     * @param index index of byte in memory
     * @param bytes new bytes
     */
    public MemoryAssignment(Index index, Iterable<Byte> bytes) {
        this.index = index;
        this.bytes = bytes;
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        int index = this.index.toInt();
        for(Byte newByte : this.bytes) {
            memory.write(index, newByte.toByte());
            index++;
        }
    }
}
