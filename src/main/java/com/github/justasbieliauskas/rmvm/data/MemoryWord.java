package com.github.justasbieliauskas.rmvm.data;

import java.nio.ByteBuffer;

/**
 * Word in memory at specific address.
 *
 * @author Justas Bieliauskas
 */
public class MemoryWord implements RWord
{
    private final byte[] memory;

    private final RWord address;

    /**
     * @param memory memory
     * @param address address
     */
    public MemoryWord(byte[] memory, RWord address) {
        this.memory = memory;
        this.address = address;
    }

    @Override
    public int toInt() {
        return ByteBuffer.wrap(
            this.memory,
            this.address.toInt(),
            Integer.BYTES
        ).getInt();
    }
}
