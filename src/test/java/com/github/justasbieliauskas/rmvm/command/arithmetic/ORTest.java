package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@Link OR}
 *
 * @author Linas Jurgelėnas
 */
public class ORTest {

    @Test
    public void calculatesOR() {
        DefaultRegister a = new DefaultRegister(56);
        DefaultRegister b = new DefaultRegister(72);
        DefaultRegister status = new DefaultRegister(6);
        new OR(a, b, status).execute();
        assertEquals(a.toInt(), 120);
    }
}