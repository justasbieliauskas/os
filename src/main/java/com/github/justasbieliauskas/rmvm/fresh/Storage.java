package com.github.justasbieliauskas.rmvm.fresh;

/**
 * External storage.
 *
 * @author Justas Bieliauskas
 */
public interface Storage
{
    /**
     * Reads text from storage.
     *
     * @param offset start index of desired text
     * @param length length of desired text
     * @return text from file
     * @throws Exception if error was raised while reading
     */
    String text(int offset, int length) throws Exception;

    /**
     * Writes text to storage.
     *
     * @param text text to write
     * @param offset offset in storage to write text at
     * @throws Exception if error was raised while writing
     */
    void write(String text, int offset) throws Exception;
}
