package com.github.justasbieliauskas.rmvm;

/**
 * Operating system.
 *
 * @author Justas Bieliauskas
 */
public interface OS
{
    /**
     * Execute an os command.
     *
     * @param command command name
     * @throws Exception if executing a command fails
     */
    void execute(String command) throws Exception;
}
