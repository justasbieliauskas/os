package com.github.justasbieliauskas.rmvm.data;

/**
 * Symbol from id.
 *
 * @author Justas Bieliauskas
 */
public class IdSymbol implements Id
{
    private final Id id;

    private final Scalar index;

    public IdSymbol(Id id, int index) {
        this(id, () -> index);
    }

    public IdSymbol(Id id, Scalar index) {
        this.id = id;
        this.index = index;
    }

    @Override
    public String asString() {
        return this.id.asString().charAt(this.index.toInt()) + "";
    }
}
