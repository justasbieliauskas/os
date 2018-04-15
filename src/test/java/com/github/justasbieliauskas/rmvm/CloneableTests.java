package com.github.justasbieliauskas.rmvm;

/**
 * Multiple cloneable tests as one.
 *
 * @author Justas Bieliauskas
 */
public class CloneableTests implements CloneableTest
{
    private final CloneableTest[] tests;

    /**
     * @param tests tests
     */
    public CloneableTests(CloneableTest... tests) {
        this.tests = tests;
    }

    @Override
    public void test() {
        for(Test test : this.tests) {
            test.test();
        }
    }

    @Override
    public CloneableTest with(int value) {
        CloneableTest[] tests = new CloneableTest[this.tests.length];
        for(int i = 0; i != this.tests.length; i++) {
            tests[i] = this.tests[i].with(value);
        }
        return new CloneableTests(tests);
    }
}
