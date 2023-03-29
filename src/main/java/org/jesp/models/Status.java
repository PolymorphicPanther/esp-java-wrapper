package org.jesp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

/**
 * Class for Status
 * Represents the current status for a given provider
 *
 * @param name         - name of the provider, "National" represents Eskom, may also be name of a municipal override e.g. "Cape Town"
 * @param nextStages   - array of next stages
 * @param stage        - current stage e.g. "0","1","2" etc...
 * @param stageUpdated - time the stage was updated
 */
public record Status(String name, @JsonProperty("next_stages") NextStage[] nextStages, String stage,
                     @JsonProperty("stage_updated") ZonedDateTime stageUpdated) {
}
