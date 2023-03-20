package org.example.models;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("allowance")
public record AllowanceCheckResponse(int count, int limit, String type) {
}
