package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.data.Id;

import java.util.Iterator;

/**
 * Sequence of {@link Id} as array of strings.
 *
 * @author Justas Bieliauskas
 */
public class IdsAsStrings implements Iterable<Id>
{
    private final String[] strings;

    public IdsAsStrings(String... strings) {
        this.strings = strings;
    }

    @Override
    public Iterator<Id> iterator() {
        String[] strings = this.strings;
        return new Iterator<Id>() {
            private int iterations = 0;

            @Override
            public boolean hasNext() {
                return this.iterations < strings.length;
            }

            @Override
            public Id next() {
                String string = strings[this.iterations++];
                return () -> string;
            }
        };
    }
}
