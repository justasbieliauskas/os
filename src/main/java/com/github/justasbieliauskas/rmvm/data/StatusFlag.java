package com.github.justasbieliauskas.rmvm.data;

/**
 * Flag (aka bit) in least significant byte of status register.
 *
 * TODO: consider FlagIndex as anonymous.
 *
 * @author Justas Bieliauskas
 */
public class StatusFlag implements Flag
{
    private final WordByte lsByte;

    private final RWord index;

    /**
     * @param status status register
     * @param id flag identifier
     */
    public StatusFlag(Register status, char id) {
        this(status, new FlagIndex(id));
    }

    /**
     * @param status status register
     * @param index bit index in given least significant byte of status register as int
     */
    public StatusFlag(Register status, int index) {
        this(status, () -> index);
    }

    private StatusFlag(Register status, RWord index) {
        this.lsByte = new WordByte(status, 0);
        this.index = index;
    }

    @Override
    public void assign(boolean to1) {
        byte bit = (byte) (1 << this.index.toInt());
        byte result;
        if(to1) {
            result = (byte) (this.lsByte.toByte() | bit);
        } else {
            result = (byte) (this.lsByte.toByte() & ~bit);
        }
        this.lsByte.assign(result);
    }

    @Override
    public boolean isTrue() {
        return ((this.lsByte.toByte() >> this.index.toInt()) & 1) == 1;
    }
}
