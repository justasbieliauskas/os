package com.github.justasbieliauskas.rmvm.command.arithmetic;

import com.github.justasbieliauskas.rmvm.command.arithmetic.AND;
import com.github.justasbieliauskas.rmvm.data.DefaultRegister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link NOT}.
 *
 * @author Aidas Kvedaravicius
 */

public class NOTTest
{
    @Test
    public void changesZerosToOnes(){
        DefaultRegister a = new DefaultRegister(0);
        new NOT(a).execute();
        assertEquals(a.toInt(), -1);
    }

}