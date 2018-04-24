package com.github.justasbieliauskas.rmvm.fake;

import java.util.Iterator;

/**
 * Commands as array of strings.
 *
 * @author Justas Bieliauskas
 */
public class Commands implements Iterable<String>
{
    private final String[] commands;

    public Commands(String... commands) {
        this.commands = commands;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < Commands.this.commands.length;
            }
            @Override
            public String next() {
                return Commands.this.commands[this.index++];
            }
        };
    }
}
