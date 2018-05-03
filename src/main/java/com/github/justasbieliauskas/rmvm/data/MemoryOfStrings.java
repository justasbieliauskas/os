package com.github.justasbieliauskas.rmvm.data;

/**
 * Memory consisting of strings.
 *
 * @author Justas Bieliauskas
 */
public class MemoryOfStrings implements Memory
{
    private final String[] strings;

    /**
     * @param strings strings
     */
    public MemoryOfStrings(String... strings) {
        this.strings = strings;
    }

    @Override
    public byte byteAt(int index) {
        int stringIndex = 0;
        while(index >= this.strings[stringIndex].length()) {
            index -= this.strings[stringIndex].length();
            stringIndex++;
        }
        return (byte) this.strings[stringIndex].charAt(index);
    }

    @Override
    public void write(byte value, int index) {
        int stringIndex = 0;
        while(index >= this.strings[stringIndex].length()) {
            index -= this.strings[stringIndex].length();
            stringIndex++;
        }
        StringBuilder replacement = new StringBuilder(this.strings[stringIndex]);
        replacement.setCharAt(index, (char) value);
        this.strings[stringIndex] = replacement.toString();
    }
}
