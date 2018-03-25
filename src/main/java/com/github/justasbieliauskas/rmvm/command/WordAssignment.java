package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.RWord;
import com.github.justasbieliauskas.rmvm.LWord;

/**
 * Transfer of a word to word holder.
 * E.g. word from memory to a register, vice versa, etc.
 *
 * @author Justas Bieliauskas
 */
public class WordAssignment implements Command
{
    private final LWord assigned;

    private final RWord assignee;

    public WordAssignment(LWord assigned, RWord assignee) {
        this.assigned = assigned;
        this.assignee = assignee;
    }

    @Override
    public void execute() {
        this.assigned.assign(this.assignee.value());
    }
}
