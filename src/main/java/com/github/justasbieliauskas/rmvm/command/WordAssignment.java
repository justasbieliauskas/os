package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.LWord;
import com.github.justasbieliauskas.rmvm.data.RWord;

/**
 * Assigning one word to another.
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
        this.assigned.assign(this.assignee.toInt());
    }
}
