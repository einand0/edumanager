package com.einando.edumanager.controller;

import com.einando.edumanager.dto.TeacherRequestDTO;
import com.einando.edumanager.entity.Teacher;
import com.einando.edumanager.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teacherService.createTeacher(dto));
    }
}
