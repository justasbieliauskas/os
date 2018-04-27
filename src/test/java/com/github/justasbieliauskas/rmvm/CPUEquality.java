package com.github.justasbieliauskas.rmvm;

import com.github.justasbieliauskas.rmvm.cpu.CPU;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Assertion that two processors are equal.
 *
 * @author Justas Bieliauskas
 */
public class CPUEquality implements Test
{
    private final CPU subject;

    private final CPU expected;

    /**
     * @param subject subject processor
     * @param expected expected processor
     */
    public CPUEquality(CPU subject, CPU expected) {
        this.subject = subject;
        this.expected = expected;
    }

    @Override
    public void test() {
        Map<String, Long> registers = this.subject.toMap();
        for(Map.Entry<String, Long> pair : this.expected.toMap().entrySet()) {
            if(!registers.containsKey(pair.getKey())) {
                fail(pair.getKey() + " not in subject processor.");
            }
            assertEquals(
                pair.getKey() + " registers are not equal.",
                pair.getValue(),
                registers.get(pair.getKey())
            );
        }
    }
}
