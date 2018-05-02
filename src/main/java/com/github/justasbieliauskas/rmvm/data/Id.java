package com.github.justasbieliauskas.rmvm.data;

/**
 * Identifier, e.g. command name, mnemonic.
 *
 * @author Justas Bieliauskas
 */
public interface Id
{
    /**
     * Converts itself to string.
     *
     * @return string representation
     */
    String asString();
}
