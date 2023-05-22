package io.github.polymorphicpanther.jesp.models;

/**
 * Class for Area Search Response
 *
 * @param areas - array of areas detected by search
 */
public record AreaSearchResponse(Area[] areas) {
}