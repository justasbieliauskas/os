package com.github.justasbieliauskas.rmvm.data;

import java.lang.*;
import java.util.Iterator;

/**
 * All bytes inside word.
 *
 * @author Justas Bieliauskas
 */
public class WordBytes implements Iterable<java.lang.Byte>
{
    private final Word word;

    private final Scalar size;

    /**
     * @param word word to extract bytes from
     * @param size number of bytes per word
     */
    public WordBytes(Word word, Scalar size) {
        this.word = word;
        this.size = size;
    }

    @Override
    public Iterator<java.lang.Byte> iterator() {
        int size = this.size.toInt();
        return new Iterator<java.lang.Byte>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            @Override
            public java.lang.Byte next() {
                return new WordByte(
                    WordBytes.this.word,
                    this.index++
                ).toByte();
            }
        };
    }
}
