package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Id;

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
    void execute(Id command) throws Exception;
}
