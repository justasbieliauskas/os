package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.CPUOfRegisters;

/**
 * Demo.
 *
 * @author Justas Bieliauskas
 */
public class Main
{
    public static void main(String[] args) {
        Shell shell = new Shell(
            new OSWithCPU(new CPUOfRegisters()),
            "registers"
        );
        try {
            shell.run();
        } catch (Exception e) {
            System.out.println("Failed to run shell.");
            e.printStackTrace();
        }
    }
}
