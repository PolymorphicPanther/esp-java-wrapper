package io.github.polymorphicpanther.jesp.models;

/**
 * Class for Area Info Response
 *
 * @param events   - sorted list of events
 * @param info     - geographical info about the queried area
 * @param schedule - raw loadshedding schedule, per stage
 */
public record AreaInfoResponse(Event[] events, Info info, Schedule schedule) {
}