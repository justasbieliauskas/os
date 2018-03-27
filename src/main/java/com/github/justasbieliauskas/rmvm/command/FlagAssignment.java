package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.ByteWithModifiedBit;
import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.LWordByte;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Changing a flag in status register.
 *
 * @author Justas Bieliauskas
 */
public class FlagAssignment implements Command
{
    private final ByteAssignment assignFlag;

    /**
     * @param status status register
     * @param index flag index in least significant byte of status register
     * @param to1 should bit be changed to 1 (true) or 0 (false)
     */
    public FlagAssignment(Register status, int index, Condition to1) {
        this(new LWordByte(status, 0), index, to1);
    }

    private FlagAssignment(LWordByte firstByte, int index, Condition to1) {
        this.assignFlag = new ByteAssignment(
            firstByte,
            new ByteWithModifiedBit(firstByte, index, to1)
        );
    }

    @Override
    public void execute() {
        this.assignFlag.execute();
    }
}
