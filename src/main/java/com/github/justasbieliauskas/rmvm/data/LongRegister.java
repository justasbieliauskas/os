package com.github.justasbieliauskas.rmvm.data;

/**
 * Register using simple long value.
 *
 * @author Justas Bieliauskas
 */
public class LongRegister implements Register
{
    private long value;

    /**
     * Constructor for initializing to 0.
     */
    public LongRegister() {
        this(0);
    }

    /**
     * Default constructor.
     *
     * @param value initial value
     */
    public LongRegister(long value) {
        this.value = value;
    }

    @Override
    public long toLong() {
        return this.value;
    }

    @Override
    public void change(long value) {
        this.value = value;
    }
}
