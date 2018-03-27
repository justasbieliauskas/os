package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.LWord;
import com.github.justasbieliauskas.rmvm.data.LWordByte;
import com.github.justasbieliauskas.rmvm.data.RWord;
import com.github.justasbieliauskas.rmvm.data.RWordByte;

/**
 * Assigning one word to another.
 *
 * FIXME: consider simply assigning word to word.
 *
 * @author Justas Bieliauskas
 */
public class WordAssignment implements Command
{
    private final Commands assignBytes;

    /**
     * @param lWord assigned
     * @param rWord assignee
     */
    public WordAssignment(LWord lWord, RWord rWord) {
        this.assignBytes = new Commands(
            new ByteAssignment(new LWordByte(lWord, 0), new RWordByte(rWord, 0)),
            new ByteAssignment(new LWordByte(lWord, 1), new RWordByte(rWord, 1)),
            new ByteAssignment(new LWordByte(lWord, 2), new RWordByte(rWord, 2)),
            new ByteAssignment(new LWordByte(lWord, 3), new RWordByte(rWord, 3))
        );
    }

    @Override
    public void execute() {
        this.assignBytes.execute();
    }
}
