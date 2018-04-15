package com.github.justasbieliauskas.rmvm.data;

/**
 * Index identified by symbol in symbol array.
 *
 * @author Justas Bieliauskas
 */
public class SymbolIndex implements Index
{
    private final char symbol;

    private final char[] symbols;

    /**
     * @param symbol searched symbol
     * @param symbols possible symbols
     */
    public SymbolIndex(char symbol, char... symbols) {
        this.symbol = symbol;
        this.symbols = symbols;
    }

    @Override
    public int toInt() {
        // TODO: find a nicer way
        for(int i = 0; i != this.symbols.length; i++) {
            if(this.symbols[i] == this.symbol) {
                return i;
            }
        }
        return -1;
    }
}
