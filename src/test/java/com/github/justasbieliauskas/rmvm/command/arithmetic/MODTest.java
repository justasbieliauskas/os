package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@Link MOD}.
 *
 *
 * @Author Linas Jurgelėnas
 */
public class MODTest {

    @Test
    public void moduleAByB() {
        DefaultRegister a = new DefaultRegister(11);
        DefaultRegister b = new DefaultRegister(3);
        DefaultRegister status = new DefaultRegister(6);
        new MOD(a, b, status).execute();
        assertEquals(a.toInt(), 2);
    }

    @Test
    public void moduleAByO() {
        DefaultRegister a = new DefaultRegister(11);
        DefaultRegister b = new DefaultRegister(0);
        DefaultRegister status = new DefaultRegister(6);
        new MOD(a, b, status).execute();
        assertEquals(status.toInt(), 2);
    }
}