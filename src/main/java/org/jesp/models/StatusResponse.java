package org.jesp.models;

import java.util.HashMap;

/**
 * Class for Status Response
 * Note: the Eskom key refers to the national status.
 * Other keys in the status refer to different municipalities and potential overrides from the National status; most typically present is the key for capetown
 *
 * @param status - status map
 */
public record StatusResponse(HashMap<String, Status> status) {
}
