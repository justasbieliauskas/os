package com.github.justasbieliauskas.rmvm.refactor.instruction.arithmetic;

import com.github.justasbieliauskas.rmvm.refactor.data.*;
import com.github.justasbieliauskas.rmvm.refactor.instruction.Instruction;
import com.github.justasbieliauskas.rmvm.refactor.instruction.Instructions;
import com.github.justasbieliauskas.rmvm.refactor.instruction.RegisterAssignment;

/**
 * AND, OR, XOR instruction.
 * Operation is determined by its name - one of "AND", "OR", "XOR".
 *
 * @author Justas Bieliauskas
 */
public class LogicInstruction implements Instruction
{
    private final Instructions instructions;

    /**
     * Constructor for testing
     *
     * @param resultIndex result register index as integer
     * @param statusIndex status register index as integer
     * @param first first register as integer
     * @param second second register as integer
     * @param name operation name
     */
    LogicInstruction(
        int resultIndex,
        int statusIndex,
        int first,
        int second,
        int status,
        char[] name
    ) {
        this(
            () -> resultIndex,
            () -> statusIndex,
            () -> first,
            () -> second,
            () -> status,
            name
        );
    }

    private LogicInstruction(
        Index resultIndex,
        Index statusIndex,
        Word first,
        Word second,
        Word status,
        char[] name
    ) {
        this(
            resultIndex,
            statusIndex,
            new NthWord(
                new Word[] {
                    () -> first.toInt() & second.toInt(),
                    () -> first.toInt() | second.toInt(),
                    () -> first.toInt() ^ second.toInt()
                },
                new SymbolIndex(name[0], 'A', 'O', 'X')
            ),
            status
        );
    }

    private LogicInstruction(
        Index resultIndex,
        Index statusIndex,
        Word result,
        Word status
    ) {
        this.instructions = new Instructions(
            new RegisterAssignment(resultIndex, result),
            new RegisterAssignment(
                statusIndex,
                new WordWithFlag(
                    new WordWithFlag(
                        new WordWithFlag(status, result),
                        'C',
                        () -> false
                    ),
                    'O',
                    () -> false
                )
            )
        );
    }

    @Override
    public void change(Register[] processor, Memory memory) {
        this.instructions.change(processor, memory);
    }
}
