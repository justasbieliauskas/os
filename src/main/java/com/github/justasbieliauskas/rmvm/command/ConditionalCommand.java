package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.Condition;

/**
 * Executes first command provided given condition evaluates to true.
 * Otherwise, executes second command.
 *
 * @author Justas Bieliauskas
 */
public class ConditionalCommand implements Command
{
    private final Command command1;

    private final Command command2;

    private final Condition condition;

    /**
     * @param command1 first command
     * @param command2 second command
     * @param condition condition
     */
    public ConditionalCommand(Command command1, Command command2, Condition condition) {
        this.command1 = command1;
        this.command2 = command2;
        this.condition = condition;
    }

    @Override
    public void execute() {
        if(this.condition.isTrue()) {
            this.command1.execute();
        } else {
            this.command2.execute();
        }
    }
}
