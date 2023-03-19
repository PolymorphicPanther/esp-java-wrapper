package org.example;

import org.jetbrains.annotations.NotNull;

public enum SampleInfoTest {
    CURRENT,
    DATA;

    public @NotNull String toString(){
        return this.name().toLowerCase();
    }
}
