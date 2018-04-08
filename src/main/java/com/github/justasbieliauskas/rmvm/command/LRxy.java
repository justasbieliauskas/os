package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Register;
import com.github.justasbieliauskas.rmvm.data.HexAddress;
import com.github.justasbieliauskas.rmvm.data.MemoryWord;

/**
 * LRxy command.
 *
 * @author Justas Bieliauskas
 */
public class LRxy implements Command
{
    private final WordAssignment assignment;

    /**
     * @param register general purpose register
     * @param memory virtual memory
     * @param page memory page index
     * @param cell cell index in that page
     */
    public LRxy(Register register, byte[] memory, char page, char cell) {
        this.assignment = new WordAssignment(
            register,
            new MemoryWord(memory, new HexAddress(page, cell))
        );
    }

    @Override
    public void execute() {
        this.assignment.execute();
    }
}
