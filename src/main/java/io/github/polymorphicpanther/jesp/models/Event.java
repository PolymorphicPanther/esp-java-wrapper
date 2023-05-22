package io.github.polymorphicpanther.jesp.models;

import java.time.ZonedDateTime;

/**
 * Class for Event
 *
 * @param start - event start time
 * @param end   - event end time
 * @param note  - may describe the stage e.g. "Stage 2"
 */
public record Event(ZonedDateTime start, ZonedDateTime end, String note) {
}
