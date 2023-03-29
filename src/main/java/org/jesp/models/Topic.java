package org.jesp.models;

import java.time.ZonedDateTime;

/**
 * Class for Topic
 *
 * @param active    - time of last activity of the post
 * @param body      - content of the post
 * @param category  - category of the topic e.g. Electricity, Advice, Events etc...
 * @param distance  - distance
 * @param followers - number of followers for the topic
 * @param timestamp - time topic was started
 */
public record Topic(ZonedDateTime active, String body, String category, float distance, int followers,
                    ZonedDateTime timestamp) {
}
