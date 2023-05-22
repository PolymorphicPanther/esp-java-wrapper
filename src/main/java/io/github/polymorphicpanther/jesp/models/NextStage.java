package io.github.polymorphicpanther.jesp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

/**
 * Class for Next Stage
 *
 * @param stage      - stage number e.g. "1", "2", "3" etc..
 * @param stageStart - stage start time
 */
public record NextStage(String stage, @JsonProperty("stage_start_timestamp") ZonedDateTime stageStart) {
}
