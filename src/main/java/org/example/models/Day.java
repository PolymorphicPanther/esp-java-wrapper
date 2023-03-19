package org.example.models;

import java.time.LocalDate;

public record Day(LocalDate date, String name, DayStages stages) {
}
