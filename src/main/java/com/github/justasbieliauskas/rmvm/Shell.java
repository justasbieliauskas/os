package com.github.justasbieliauskas.rmvm;

import java.util.Arrays;
import java.util.Iterator;

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
     * Constructor for initializing with pre-defined command sequence.
     *
     * @param os os
     * @param commands commands to run as array
     */
    public Shell(OS os, String... commands) {
        this(
            os,
            () -> Arrays.asList(commands).iterator()
        );
    }

    /**
     * Default constructor.
     *
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
