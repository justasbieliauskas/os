package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.LByte;
import com.github.justasbieliauskas.rmvm.data.RByte;

/**
 * FIXME: check the wording.
 * Assigning one byte to another.
 *
 * @author Justas Bieliauskas
 */
public class ByteAssignment implements Command
{
    private final LByte lByte;

    private final RByte rByte;

    /**
     * @param lByte assigned
     * @param rByte assignee
     */
    public ByteAssignment(LByte lByte, RByte rByte) {
        this.lByte = lByte;
        this.rByte = rByte;
    }

    @Override
    public void execute() {
        this.lByte.assign(this.rByte.toByte());
    }
}
