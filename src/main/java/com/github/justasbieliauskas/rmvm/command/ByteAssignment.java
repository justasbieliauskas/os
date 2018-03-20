package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.Byte;
import com.github.justasbieliauskas.rmvm.ByteStorage;

/**
 * Transfer of a byte to byte holder.
 * E.g. byte from memory to least significant byte of a register, etc.
 *
 * @author Justas Bieliauskas
 */
public class ByteAssignment implements Command
{
    private final ByteStorage assigned;

    private final Byte assignee;

    public ByteAssignment(ByteStorage assigned, Byte assignee) {
        this.assigned = assigned;
        this.assignee = assignee;
    }

    @Override
    public void execute() {
        this.assigned.assign(this.assignee.value());
    }
}
