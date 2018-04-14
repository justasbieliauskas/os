package com.github.justasbieliauskas.rmvm.refactor.data;

/**
 * Word with modified flag.
 *
 * @author Justas Bieliauskas
 */
public class WordWithFlag implements Word
{
    private final WordWithByte word;

    /**
     * Constructor for testing.
     *
     * @param word word
     * @param byteIndex byte index in word
     * @param flagIndex flag index in byte
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    WordWithFlag(Word word, int byteIndex, int flagIndex, boolean to1) {
        this(word, byteIndex, () -> flagIndex, () -> to1);
    }

    private WordWithFlag(Word word, int byteIndex, Index flagIndex, Condition to1) {
        this.word = new WordWithByte(
            word,
            byteIndex,
            new ByteWithFlag(
                new WordByte(word, byteIndex),
                flagIndex,
                to1
            )
        );
    }

    @Override
    public int toInt() {
        return this.word.toInt();
    }
}
