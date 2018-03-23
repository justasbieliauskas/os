package com.github.justasbieliauskas.rmvm.command;

/**
 * Many commands as one.
 *
 * @author Justas Bieliauskas
 */
public class Composite implements Command
{
    private final Command[] commands;

    public Composite(Command... commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for(Command command : this.commands) {
            command.execute();
        }
    }
}
