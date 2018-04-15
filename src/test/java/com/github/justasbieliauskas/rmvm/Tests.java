package com.github.justasbieliauskas.rmvm;

/**
 * Multiple tests as one.
 *
 * @author Justas Bieliauskas
 */
public class Tests implements Test
{
    private final Test[] tests;

    /**
     * @param tests tests
     */
    public Tests(Test... tests) {
        this.tests = tests;
    }

    @Override
    public void test() {
        for(Test test : this.tests) {
            test.test();
        }
    }
}
