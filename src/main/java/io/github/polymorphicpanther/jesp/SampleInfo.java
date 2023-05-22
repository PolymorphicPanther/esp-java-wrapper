package io.github.polymorphicpanther.jesp;

import org.jetbrains.annotations.NotNull;

public enum SampleInfo {
    CURRENT,
    DATA;

    public @NotNull String toString(){
        return this.name().toLowerCase();
    }
}
