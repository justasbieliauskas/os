package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.Register;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * NOT command test.
 */
public class NOTTest
{
    @Test
    public void negatesRegister() throws Exception {
        Register A = new Register();
        A.assign(60);
        new NOT(A).execute();
        assertEquals(A.value(), -61);
    }
}