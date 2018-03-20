package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.Register;

/**
 * NOT not.
 *
 * @author Justas Bieliauskas
 */
public class NOT implements Command
{
    private final Command not;

    public NOT(Register register) {
        this(new WordAssignment(register, () -> ~ register.value()));
    }

    private NOT(Command not) {
        this.not = not;
    }

    @Override
    public void execute() {
        this.not.execute();
    }
}
