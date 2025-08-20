package com.einando.edumanager.dto;

import java.time.LocalDate;

public record EnrollmentResponseDTO(Long id, LocalDate date, String studentName, String courseName) {
}
