package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Id;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Sequence of commands from stdin.
 * Sequence ends when "quit" is entered.
 *
 * @author Justas Bieliauskas
 */
public class ConsoleCommands implements Iterable<Id>
{
    private final Scanner scanner;

    private final String prompt;

    /**
     * @param prompt message to prompt to user before reading input
     */
    public ConsoleCommands(String prompt) {
        this.scanner = new Scanner(System.in);
        this.prompt = prompt;
    }

    @Override
    public Iterator<Id> iterator() {
        return new Iterator<Id>() {
            private String command = "";

            @Override
            public boolean hasNext() {
                System.out.print(prompt);
                this.command = scanner.nextLine();
                return !this.command.equals("quit");
            }

            @Override
            public Id next() {
                return () -> this.command;
            }
        };
    }
}
