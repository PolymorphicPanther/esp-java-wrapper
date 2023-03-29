package org.jesp.models;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Class for Allowance Check Response
 *
 * @param count - current call quota used
 * @param limit - allocated call quota
 * @param type  - quota type
 */
@JsonRootName("allowance")
public record AllowanceCheckResponse(int count, int limit, String type) {
}
