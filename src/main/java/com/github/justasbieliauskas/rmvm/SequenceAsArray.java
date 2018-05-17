package com.github.justasbieliauskas.rmvm;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Sequence as array.
 *
 * @author Justas Bieliauskas
 */
public class SequenceAsArray<T> implements Iterable<T>
{
    private final T[] items;

    /**
     * @param items array
     */
    public SequenceAsArray(T... items) {
        this.items = items;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(this.items).iterator();
    }
}
