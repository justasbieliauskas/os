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
    private final LByte assigned;

    private final RByte assignee;

    /**
     * @param assigned assigned
     * @param assignee assignee
     */
    public ByteAssignment(LByte assigned, RByte assignee) {
        this.assigned = assigned;
        this.assignee = assignee;
    }

    @Override
    public void execute() {
        this.assigned.assign(this.assignee.toByte());
    }
}
