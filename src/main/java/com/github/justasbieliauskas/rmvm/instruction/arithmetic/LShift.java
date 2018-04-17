package com.github.justasbieliauskas.rmvm.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.data.*;
import com.github.justasbieliauskas.rmvm.instruction.Instruction;
import com.github.justasbieliauskas.rmvm.instruction.Instructions;
import com.github.justasbieliauskas.rmvm.instruction.RegisterAssignment;

/**
 * Left shift instruction.
 *
 * @author Justas Bieliauskas
 */
public class LShift implements Instruction
{
    private final Instructions instructions;

    /**
     * Constructor for testing.
     *
     * @param word word as integer
     * @param count shift count as integer
     * @param status status register with hand-picked flag values
     */
    LShift(int word, int count, WordWithFlag status) {
        this(() -> 0, () -> 1, () -> word, () -> count, status);
    }

    private LShift(
        Index resultIndex,
        Index statusIndex,
        Word word,
        Word count,
        Word status
    ) {
        this(
            resultIndex,
            statusIndex,
            () -> word.toInt() << count.toInt(),
            () -> word.toInt() << (count.toInt() - 1),
            count,
            status
        );
    }

    private LShift(
        Index resultIndex,
        Index statusIndex,
        Word result,
        Word prior,
        Word count,
        Word status
    ) {
        this(
            resultIndex,
            statusIndex,
            result,
            count,
            status,
            new WordFlag(result, Integer.BYTES - 1, 7),
            new WordFlag(prior, Integer.BYTES - 1, 7),
            new WordFlag(status, 'O')
        );
    }

    private LShift(
        Index resultIndex,
        Index statusIndex,
        Word result,
        Word count,
        Word status,
        WordFlag resultFlag,
        WordFlag priorFlag,
        WordFlag overflow
    ) {
        this.instructions = new Instructions(
            new RegisterAssignment(resultIndex, result),
            new RegisterAssignment(
                statusIndex,
                new WordWithFlag(
                    new WordWithFlag(
                        new WordWithFlag(status, result),
                        'C',
                        priorFlag
                    ),
                    'O',
                    () -> {
                        if(count.toInt() == 1) {
                            return resultFlag.isTrue() != priorFlag.isTrue();
                        }
                        return overflow.isTrue();
                    }
                )
            )
        );
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        this.instructions.change(processor, memory);
    }
}
