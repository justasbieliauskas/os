package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.Command;
import com.github.justasbieliauskas.rmvm.command.WordAssignment;
import com.github.justasbieliauskas.rmvm.data.Register;

/**
 * NOT command.
 *
 * *A = ~ A
 *
 * @author Aidas Kvedaravicius
 */

public class NOT implements Command{

    private final WordAssignment wordAssignment;

    public NOT(Register a) {
        this.wordAssignment = new WordAssignment(a, () -> ~a.toInt());
    }

    @Override
    public void execute() {
        this.wordAssignment.execute();
    }
}
