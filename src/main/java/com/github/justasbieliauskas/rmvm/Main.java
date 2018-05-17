package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.*;
import com.github.justasbieliauskas.rmvm.cpu.instruction.CPUAfterCOMP;
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
                new FirstNonEmptyCPU(
                    new CPUIfIdMatches(
                        "HALT",
                        new SafeNewCPUIgnoringId(new CPUAfterHALT())
                    ),
                    new CPUIfIdMatches(
                        "COMP",
                        new SafeNewCPUIgnoringId(new CPUAfterCOMP())
                    )
                )
            ),
            new SequenceAsArray<>(() -> "COMP")
        );
        try {
            shell.run();
        } catch (Exception e) {
            System.out.println("Failed to run shell.");
            e.printStackTrace();
        }
    }
}
