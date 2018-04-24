package com.github.justasbieliauskas.rmvm.fake;

import com.github.justasbieliauskas.rmvm.OS;

/**
 * Variant of os that simply outputs given command to stdout
 * instead of executing it.
 *
 * @author Justas Bieliauskas
 */
public class MirrorOS implements OS
{
    @Override
    public void execute(String command) throws Exception {

    }
}
