package com.einando.edumanager.controller;

import com.einando.edumanager.dto.CourseRequestDTO;
import com.einando.edumanager.dto.CourseResponseDTO;
import com.einando.edumanager.entity.Course;
import com.einando.edumanager.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.createCourse(dto));
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<String>> getStudentsFromCourse(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(courseService.findAllStudentsFromCourse(id));
    }
}
