package com.github.justasbieliauskas.rmvm.data;

/**
 * Register.
 *
 * TODO: add terminal access.
 * TODO: make Register, RegisterInCPU, GeneralPurposeRegister...
 * TODO: pass entire cpu to commands
 *
 * @author Justas Bieliauskas
 */
public class Register implements LWord
{
    private int value;

    public Register() {
        this(0);
    }

    public Register(int value) {
        this.value = value;
    }

    @Override
    public int toInt() {
        return this.value;
    }

    @Override
    public void assign(int value) {
        this.value = value;
    }
}
