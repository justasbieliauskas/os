package com.github.justasbieliauskas.rmvm.data;

/**
 * Logical predicate with ability to create new one from identifier.
 *
 * @author Justas Bieliauskas
 */
public interface IdMatch extends Condition
{
    /**
     * Creates new match predicate from given identifier.
     *
     * @param id identifier
     * @return new match predicate
     */
    IdMatch with(Id id);
}
