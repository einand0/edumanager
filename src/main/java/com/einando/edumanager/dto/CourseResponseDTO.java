package com.einando.edumanager.dto;

import com.einando.edumanager.entity.Teacher;

public record CourseResponseDTO(Long id, String title, String description, String teacherName) {
}
