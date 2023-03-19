package org.example.models;

import java.time.ZonedDateTime;

public record Event(ZonedDateTime start, ZonedDateTime end, String note) {
}
