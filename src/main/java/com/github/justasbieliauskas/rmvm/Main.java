package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.CPUIfIdMatches;
import com.github.justasbieliauskas.rmvm.cpu.CPUOfRegisters;
import com.github.justasbieliauskas.rmvm.cpu.DisplayCPU;
import com.github.justasbieliauskas.rmvm.cpu.SafeNewCPUIgnoringId;
import com.github.justasbieliauskas.rmvm.cpu.instruction.CPUAfterHALT;
import com.github.justasbieliauskas.rmvm.data.IdEquality;

/**
 * Demo.
 *
 * @author Justas Bieliauskas
 */
public class Main
{
    public static void main(String[] args) {
        Shell shell = new Shell(
            new OSWithCPU(
                new DisplayCPU(new CPUOfRegisters()),
                new CPUIfIdMatches(
                    "HALT",
                    new SafeNewCPUIgnoringId(new CPUAfterHALT())
                )
            ),
            new SequenceAsArray<>(() -> "HALT")
        );
        try {
            shell.run();
        } catch (Exception e) {
            System.out.println("Failed to run shell.");
            e.printStackTrace();
        }
    }
}
