package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.FakeWord;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link WordAssignment}.
 *
 * @author Justas Bieliauskas
 */
public class WordAssignmentTest
{
    @Test
    public void assignsWord() throws Exception {
        FakeWord word = new FakeWord();
        new WordAssignment(word, new FakeWord(1200)).execute();
        assertEquals(word.toInt(), 1200);
    }
}