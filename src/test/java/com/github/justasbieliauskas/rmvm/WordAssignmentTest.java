package com.github.justasbieliauskas.rmvm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests correct byte assignment.
 *
 * @author Justas Bieliauskas
 */
public class WordAssignmentTest
{
    @Test
    public void execute() throws Exception {
        FakeWord word = new FakeWord();
        new WordAssignment(word, new FakeWord(78689)).execute();
        assertEquals(word.value(), 78689);
    }
}