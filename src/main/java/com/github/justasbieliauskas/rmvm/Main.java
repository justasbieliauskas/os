package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.fake.Commands;

/**
 * Demo.
 *
 * @author Justas Bieliauskas
 */
public class Main
{
    public static void main(String[] args) {
        Shell shell = new Shell(
            System.out::println,
            new Commands("load first", "show memory", "run")
        );
        try {
            shell.run();
        } catch (Exception e) {
            System.out.println("Failed to run shell.");
            e.printStackTrace();
        }
    }
}
