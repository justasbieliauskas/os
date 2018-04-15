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
     * Constructor for setting zero flag on status register.
     *
     * @param status status register
     */
    public WordWithFlag(Word status) {
        this(status, 'Z', () -> status.toInt() == 0);
    }

    /**
     * Constructor for changing with status register.
     * For possible flag identifiers, see {@link FlagIndex}.
     *
     * @param status status register
     * @param id flag identifier
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public WordWithFlag(Word status, char id, Condition to1) {
        this(status, 0, new FlagIndex(id), to1);
    }

    /**
     * Constructor for testing.
     *
     * @param word word
     * @param byteIndex byte index in word
     * @param flagIndex flag index in byte as integer
     * @param to1 should flag be changed to 1 (true) or 0 (false) as boolean
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
