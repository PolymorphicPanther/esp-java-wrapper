package io.github.polymorphicpanther.jesp.models;

import java.time.LocalDate;

/**
 * Class for Day
 * Contains the stages occurring on respective day.
 *
 * @param date   - date
 * @param name   - name of day (Monday, Tuesday etc...)
 * @param stages - different stages and their respective slots occurring on the day
 */
public record Day(LocalDate date, String name, DayStages stages) {
}
