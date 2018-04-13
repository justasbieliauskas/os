package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for MUL
 *
 * @author Linas Jurgelėnas
 */
public class MULTest {

    @Test
    public void multiplyAWithB() {
        DefaultRegister a = new DefaultRegister(11);
        DefaultRegister b = new DefaultRegister(3);
        DefaultRegister status = new DefaultRegister(6);
        new MUL(a, b, status).execute();
        assertEquals(a.toInt(), 33);
    }

    @Test
    public void MultyplyAWith0(){
        DefaultRegister a = new DefaultRegister(11);
        DefaultRegister b = new DefaultRegister(0);
        DefaultRegister status = new DefaultRegister(0);
        new MUL(a, b, status).execute();
        assertEquals(a.toInt(), 0);
        assertEquals(status.toInt(), 1);
    }

    @Test
    public void Multiply0WithB(){
        DefaultRegister a = new DefaultRegister(0);
        DefaultRegister b = new DefaultRegister(25);
        DefaultRegister status = new DefaultRegister(0);
        new MUL(a, b, status).execute();
        assertEquals(a.toInt(), 0);
        assertEquals(status.toInt(), 1);
    }

    @Test
    public void MultiplyLargerThan500(){
        DefaultRegister a = new DefaultRegister(300);
        DefaultRegister b = new DefaultRegister(25);
        DefaultRegister status = new DefaultRegister(0);
        new MUL(a, b, status).execute();
        assertEquals(a.toInt(), 7500);
        assertEquals(status.toInt(), 2);
    }
}