package io.github.polymorphicpanther.jesp.models;

/**
 * Class for Area
 *
 * @param count  - meaning not specified
 * @param id     - esp area Id
 * @param name   - common name of the area
 * @param region - region which the area fall under
 */
public record Area(int count, String id, String name, String region) {
}
