package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to be evaluated to word value.
 * E.g. address, multiplication of 2 words, etc.
 *
 * @author Justas Bieliauskas
 */
public interface Word
{
    /**
     * Word is 4 bytes and so is an integer.
     * Word treated as an integer.
     *
     * @return integer representation
     */
    int value();
}
