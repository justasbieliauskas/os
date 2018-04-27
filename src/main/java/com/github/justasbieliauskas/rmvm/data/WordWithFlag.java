package com.github.justasbieliauskas.rmvm.data;

import com.github.justasbieliauskas.rmvm.cpu.CPU;

import java.nio.ByteBuffer;

/**
 * Word with modified flag.
 *
 * TODO: better constructor documentation.
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
        this(processor, 'Z', () -> word.toLong() == 0);
    }

    /**
     * Constructor for changing a flag of status register in processor.
     *
     * @param processor processor
     * @param id flag identifier
     * @param to1 should flag be changed to 1 (true) or 0 (false)
     */
    public WordWithFlag(CPU processor, char id, Condition to1) {
        this(new CPURegister(processor, "ST"), id, to1);
    }

    /**
     * Constructor for setting carry flag.
     * Checking if result equals its counterpart in range.
     * Used in some arithmetic instructions.
     *
     * @param word word with zero flag
     * @param result result not in range
     * @param resultInRange result in range
     */
    public WordWithFlag(WordWithFlag word, Word result, WordInRange resultInRange) {
        this(word, 'C', () -> result.toLong() != resultInRange.toLong());
    }

    /**
     * Constructor for creating initial status register with one flag set
     * in which case the rest of status register is irrelevant.
     * Used in testing.
     *
     * @param id flag identifier
     * @param to1 should flag be changed to 1 (true) or 0 (false) as boolean
     */
    public WordWithFlag(char id, boolean to1) {
        this(() -> 0, id, to1);
    }

    /**
     * Constructor for testing.
     *
     * @param word word as long
     * @param byteIndex byte index in word
     * @param flagIndex flag index in byte as integer
     * @param to1 should flag be changed to 1 (true) or 0 (false) as boolean
     */
    WordWithFlag(long word, int byteIndex, int flagIndex, boolean to1) {
        this(() -> word, byteIndex, () -> flagIndex, () -> to1);
    }

    /**
     * Constructor for testing.
     *
     * @param word word
     * @param byteIndex byte index in word
     * @param flagIndex flag index in byte as integer
     * @param to1 should flag be changed to 1 (true) or 0 (false) as boolean
     */
    WordWithFlag(WordWithFlag word, int byteIndex, int flagIndex, boolean to1) {
        this(word, byteIndex, () -> flagIndex, () -> to1);
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
                .allocate(Long.BYTES)
                .putLong(word.toLong())
                .array();
            bytes[Long.BYTES - byteIndex - 1] = byteWithFlag.toByte();
            return ByteBuffer.wrap(bytes).getLong();
        };
    }

    @Override
    public long toLong() {
        return this.word.toLong();
    }
}
