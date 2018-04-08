package com.github.justasbieliauskas.rmvm.data;

/**
 * Index for register in processor by identifier.
 * Identifier is one of
 * "A", "B", "C", "D", "ST", "IC", "SI", "PI", "TI", "CS" or "PTR".
 *
 * @author Justas Bieliauskas
 */
public class RegisterIndex implements RWord
{
    private final String id;

    /**
     * @param id register identifier
     */
    public RegisterIndex(String id) {
        this.id = id;
    }

    @Override
    public int toInt() {
        char first = this.id.charAt(0);
        if(this.id.length() == 1) {
            return first - 65;
        }
        if(first == 'I') {
            return 5;
        }
        if(first == 'T') {
            return 8;
        }
        if(first == 'C') {
            return 9;
        }
        char second = id.charAt(1);
        if(first == 'S') {
            return (second == 'T') ? 4 : 6;
        }
        return (second == 'I') ? 7 : 10;
    }
}
