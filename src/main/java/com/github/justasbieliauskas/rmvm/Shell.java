package com.github.justasbieliauskas.rmvm;

/**
 * Shell to communicate with os.
 * Main class in application.
 *
 * TODO: test
 *
 * @author Justas Bieliauskas
 */
public class Shell
{
    private final OS os;

    private final Iterable<String> commands;

    /**
     * @param os os
     * @param commands commands to run
     */
    public Shell(OS os, Iterable<String> commands) {
        this.os = os;
        this.commands = commands;
    }

    /**
     * Start executing os commands.
     *
     * @throws Exception if one of commands fails
     */
    public void run() throws Exception {
        for(String command : this.commands) {
            try {
                this.os.execute(command);
            } catch (Exception e) {
                throw new Exception("Exception raised while running shell!", e);
            }
        }
    }
}
