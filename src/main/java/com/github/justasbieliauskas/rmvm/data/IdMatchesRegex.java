package com.github.justasbieliauskas.rmvm.data;

import java.util.regex.Pattern;

/**
 * Condition that given id matches regular expression.
 *
 * @author Justas Bieliauskas
 */
public class IdMatchesRegex implements IdMatch
{
    private final Id id;

    private final Id regex;

    public IdMatchesRegex(String regex) {
        this(() -> regex);
    }

    public IdMatchesRegex(Id regex) {
        this(() -> "", regex);
    }

    private IdMatchesRegex(Id id, Id regex) {
        this.id = id;
        this.regex = regex;
    }

    @Override
    public boolean isTrue() {
        return Pattern.matches(this.regex.asString(), this.id.asString());
    }

    @Override
    public IdMatch with(Id id) {
        return new IdMatchesRegex(id, this.regex);
    }
}
