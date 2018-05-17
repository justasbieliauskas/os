package com.github.justasbieliauskas.rmvm.data;

/**
 * Condition that given id equals expected id.
 *
 * @author Justas Bieliauskas
 */
public class IdEquality implements IdMatch
{
    private final Id id;

    private final Id expected;

    public IdEquality(String expected) {
        this(() -> expected);
    }

    /**
     * @param expected expected identifier compared to
     */
    public IdEquality(Id expected) {
        this(() -> "", expected);
    }

    private IdEquality(Id id, Id expected) {
        this.id = id;
        this.expected = expected;
    }

    @Override
    public boolean isTrue() {
        return this.id.asString().equals(this.expected.asString());
    }

    @Override
    public IdMatch with(Id id) {
        return new IdEquality(id, this.expected);
    }
}
