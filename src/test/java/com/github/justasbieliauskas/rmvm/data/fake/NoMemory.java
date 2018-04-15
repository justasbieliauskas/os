package com.github.justasbieliauskas.rmvm.data.fake;

import com.github.justasbieliauskas.rmvm.data.Memory;

/**
 * Fake memory with empty methods.
 * Used in testing.
 *
 * @author Justas Bieliauskas
 */
public class NoMemory implements Memory
{
    @Override
    public void write(int index, byte value) {
    }

    @Override
    public byte byteAt(int index) {
        return 0;
    }
}
