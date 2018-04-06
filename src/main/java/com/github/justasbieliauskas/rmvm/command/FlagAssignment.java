package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.WordByte;
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
     * @param byteIndex index in status register
     * @param flagIndex bit index in least significant byte of status register
     * @param to1 should bit be changed to 1 (true) or 0 (false)
     */
    public FlagAssignment(Register status, int byteIndex, int flagIndex, Condition to1) {
        this(new WordByte(status, byteIndex), flagIndex, to1);
    }

    private FlagAssignment(WordByte firstByte, int index, Condition to1) {
        this.assignFlag = new ByteAssignment(
            firstByte,
            () -> {
                byte bit = (byte) (1 << index);
                if(to1.isTrue()) {
                    return (byte) (firstByte.toByte() | bit);
                }
                return (byte) (firstByte.toByte() & ~bit);
            }
        );
    }

    @Override
    public void execute() {
        this.assignFlag.execute();
    }
}
