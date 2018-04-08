package com.github.justasbieliauskas.rmvm.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link StatusFlag}
 *
 * @author Justas Bieliauskas
 */
public class StatusFlagTest
{
    @Test
    public void extractsFlag() throws Exception {
        assertTrue(new StatusFlag(new DefaultRegister(8224), 5).isTrue());
    }

    @Test
    public void changesFlag() throws Exception {
        DefaultRegister status = new DefaultRegister(4100);
        StatusFlag flag = new StatusFlag(status, 2);
        flag.assign(false);
        assertEquals(status.toInt(), 4096);
    }
}