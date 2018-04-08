package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link ProcessorRegister}.
 *
 * @author Justas Bieliauskas
 */
public class ProcessorRegisterTest
{
    @Test
    public void extractsFromNthRegister() {
        Register[] registers = new Register[]{
            new DefaultRegister(0),
            new DefaultRegister(45),
            new DefaultRegister(0)
        };
        assertEquals(new ProcessorRegister(registers, () -> 1).toInt(), 45);
    }

    @Test
    public void assignsToNthRegister() {
        Register[] registers = new Register[]{
            new DefaultRegister(0),
            new DefaultRegister(0),
            new DefaultRegister(64),
            new DefaultRegister(0)
        };
        new ProcessorRegister(registers, () -> 2).assign(84);
        assertEquals(registers[2].toInt(), 84);
    }
}