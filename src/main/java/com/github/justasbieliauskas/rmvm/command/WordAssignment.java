package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.Word;
import com.github.justasbieliauskas.rmvm.WordStorage;

/**
 * Transfer of a word to word holder.
 * E.g. word from memory to a register, vice versa, etc.
 *
 * @author Justas Bieliauskas
 */
public class WordAssignment implements Command
{
    private final WordStorage assigned;

    private final Word assignee;

    public WordAssignment(WordStorage assigned, Word assignee) {
        this.assigned = assigned;
        this.assignee = assignee;
    }

    @Override
    public void execute() {
        this.assigned.assign(this.assignee.value());
    }
}
