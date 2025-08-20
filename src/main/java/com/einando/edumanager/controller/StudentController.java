package com.einando.edumanager.controller;

import com.einando.edumanager.dto.CourseResponseDTO;
import com.einando.edumanager.dto.StudentRequestDTO;
import com.einando.edumanager.entity.Course;
import com.einando.edumanager.entity.Student;
import com.einando.edumanager.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(dto));
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseResponseDTO>> getStudentCourses(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(studentService.findStudentCourses(id));
    }
}
