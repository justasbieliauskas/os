package com.github.justasbieliauskas.rmvm.command;

/**
 * Program command from the instruction set.
 * E.g. COMP, JGE, READ.
 *
 * @author Justas Bieliauskas
 */
public interface Command
{
    /**
     * Execute command:
     * mutate registers, write to memory, change flags, etc.
     */
    void execute();
}
