package org.jesp;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Option {
    /**
     * Name of the option
     */
    private final String name;

    /**
     * Value of the option
     */
    private final Object value;

    /**
     * Creates an option object
     *
     * @param name  the name of the option
     * @param value the value of the option
     */
    public Option(@NotNull final String name, @Nullable final Object value) {
        Objects.requireNonNull(name, "name should not be null");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name should not empty");
        }
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the name of the option
     *
     * @return the name of the option
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Gets the value of the option
     *
     * @return the value of the option
     */
    @Nullable
    public Object getValue() {
        return value;
    }
}

