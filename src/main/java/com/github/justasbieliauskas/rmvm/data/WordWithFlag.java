package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.fresh.CPU;

import java.nio.ByteBuffer;

/**
 * Word with modified flag.
 *
 * @author Justas Bieliauskas
 */
public class WordWithFlag implements Word
{
    private final Word word;

    /**
     * Constructor for changing zero flag of status register in processor.
     *
     * @param processor processor
     * @param word computation result
     */
    public WordWithFlag(CPU processor, Word word) {
        this(processor, 'Z', () -> word.toInt() == 0);
    }

    /**
     * Constructor for changing a flag of status register in processor.
     *
     * @param processor processor
     * @param id flag identifier
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public WordWithFlag(CPU processor, char id, Condition to1) {
        this(() -> processor.toMap().get("ST"), id, to1);
    }

    /**
     * Constructor for setting zero flag on status register.
     *
     * @param status status register
     * @param word word to check for zero
     */
    public WordWithFlag(Word status, Word word) {
        this(status, 'Z', () -> word.toInt() == 0);
    }

    /**
     * Constructor for hand-picking pre-defined flag values.
     * In that case, the initial status register value is irrelevant.
     *
     * @param id flag identifier
     * @param to1 should flag be changed to 1 (true) or 0 (false) as boolean
     */
    public WordWithFlag(char id, boolean to1) {
        this(() -> 0, id, to1);
    }

    /**
     * Constructor for chaining new flags.
     *
     * @param status status register
     * @param id flag identifier
     * @param to1 should flag be changed to 1 (true) or 0 (false) as boolean
     */
    public WordWithFlag(Word status, char id, boolean to1) {
        this(status, id, () -> to1);
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
        this(
            word,
            byteIndex,
            flagIndex,
            new WordByte(word, byteIndex),
            to1
        );
    }

    private WordWithFlag(
        Word word,
        int byteIndex,
        Index flagIndex,
        Byte wordByte,
        Condition to1
    ) {
        this(
            word,
            byteIndex,
            () -> {
                byte filter = (byte) (1 << flagIndex.toInt());
                if(to1.isTrue()) {
                    return (byte) (wordByte.toByte() | filter);
                }
                return (byte) (wordByte.toByte() & ~filter);
            }
        );
    }

    private WordWithFlag(Word word, int byteIndex, Byte byteWithFlag) {
        this.word = () -> {
            byte[] bytes = ByteBuffer
                .allocate(Integer.BYTES)
                .putInt(word.toInt())
                .array();
            bytes[Integer.BYTES - byteIndex - 1] = byteWithFlag.toByte();
            return ByteBuffer.wrap(bytes).getInt();
        };
    }

    @Override
    public int toInt() {
        return this.word.toInt();
    }
}
