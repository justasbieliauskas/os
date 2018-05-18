package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.*;
import com.github.justasbieliauskas.rmvm.cpu.instruction.CPUAfterCOMP;
import com.github.justasbieliauskas.rmvm.cpu.instruction.CPUAfterHALT;
import com.github.justasbieliauskas.rmvm.cpu.instruction.CPUAfterPTOR;
import com.github.justasbieliauskas.rmvm.data.IdEquality;
import com.github.justasbieliauskas.rmvm.data.IdMatchesRegex;

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
                new DisplayCPU(
                    new CPUOfRegisters(271863, 555, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                ),
                new FirstNonEmptyCPU(
                    new CPUIfIdMatches(
                        "HALT",
                        new SafeNewCPUIgnoringId(new CPUAfterHALT())
                    ),
                    new CPUIfIdMatches(
                        new IdMatchesRegex("^(A|B|C|D)TO(A|B|C|D)$"),
                        new SafeNewCPUWithId(new CPUAfterPTOR())
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
