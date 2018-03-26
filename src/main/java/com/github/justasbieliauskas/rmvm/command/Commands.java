package com.github.justasbieliauskas.rmvm.command;

/**
 * Multiple commands as one.
 *
 * @author Justas Bieliauskas
 */
public class Commands implements Command
{
    private final Command[] commands;

    public Commands(Command... commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for(Command command : this.commands) {
            command.execute();
        }
    }
}
