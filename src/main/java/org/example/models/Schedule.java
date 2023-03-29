package org.example.models;

/**
 * Class for schedule
 * Represents the raw load shedding schedule
 *
 * @param source - schedule source e.g. "https://loadshedding.eskom.co.za/"
 * @param days   - schedule days (usually 7 days including the current day)
 */
public record Schedule(String source, Day[] days) {
}
