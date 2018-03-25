package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.RByte;
import com.github.justasbieliauskas.rmvm.LByte;

/**
 * Transfer of a byte to byte holder.
 * E.g. byte from memory to least significant byte of a register, etc.
 *
 * @author Justas Bieliauskas
 */
public class ByteAssignment implements Command
{
    private final LByte assigned;

    private final RByte assignee;

    public ByteAssignment(LByte assigned, RByte assignee) {
        this.assigned = assigned;
        this.assignee = assignee;
    }

    @Override
    public void execute() {
        this.assigned.assign(this.assignee.value());
    }
}
