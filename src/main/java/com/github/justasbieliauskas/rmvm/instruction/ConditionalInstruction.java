package com.github.justasbieliauskas.rmvm.instruction;

import com.github.justasbieliauskas.rmvm.data.Memory;
import com.github.justasbieliauskas.rmvm.data.Condition;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * Execution of first instruction provided given condition is satisfied or
 * second instruction otherwise.
 *
 * @author Justas Bieliauskas
 */
public class ConditionalInstruction implements Instruction
{
    private final Instruction instruction1;

    private final Instruction instruction2;

    private final Condition condition;

    /**
     * @param instruction1 first instruction
     * @param instruction2 second instruction
     * @param condition condition
     */
    public ConditionalInstruction(
        Instruction instruction1,
        Instruction instruction2,
        Condition condition
    ) {
        this.instruction1 = instruction1;
        this.instruction2 = instruction2;
        this.condition = condition;
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        if(this.condition.isTrue()) {
            this.instruction1.change(processor, memory);
        } else {
            this.instruction2.change(processor, memory);
        }
    }
}
