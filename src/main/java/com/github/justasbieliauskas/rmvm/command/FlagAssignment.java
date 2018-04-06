package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.Flag;

/**
 * Changing of flag's value.
 *
 * @author Justas Bieliauskas
 */
public class FlagAssignment implements Command
{
    private final Flag flag;

    private final Condition condition;

    /**
     * @param flag flag - ZF, CF, OF, DF.
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public FlagAssignment(Flag flag, Condition to1) {
        this.flag = flag;
        this.condition = to1;
    }

    @Override
    public void execute() {
        this.flag.assign(this.condition.isTrue());
    }
}
