package com.github.justasbieliauskas.rmvm;

/**
 * Entity able to be evaluated to word.
 * E.g. address, multiplication of 2 words, etc.
 *
 * Appears on the right side of word assignment.
 *
 * @author Justas Bieliauskas
 */
public interface RWord
{
    /**
     * @return integer representation
     */
    int value();
}
