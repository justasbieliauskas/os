package com.github.justasbieliauskas.rmvm.data;

/**
 * Instruction address from code segment and relative offset.
 * TODO: remove
 *
 * @author Justas Bieliauskas
 */
public class InstructionAddress implements RWord
{
    private final DefaultRegister code;

    private final RWord offset;

    /**
     * @param code code segment (CS) register
     * @param offset relative offset to instruction
     */
    public InstructionAddress(DefaultRegister code, RWord offset) {
        this.code = code;
        this.offset = offset;
    }

    @Override
    public int toInt() {
        return this.code.toInt() + this.offset.toInt() * Integer.BYTES;
    }
}
