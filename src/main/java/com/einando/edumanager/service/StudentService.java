package com.einando.edumanager.service;

import com.einando.edumanager.dto.CourseResponseDTO;
import com.einando.edumanager.dto.StudentRequestDTO;
import com.einando.edumanager.entity.Course;
import com.einando.edumanager.entity.Student;
import com.einando.edumanager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(StudentRequestDTO dto) {
        Student newStudent = new Student();
        newStudent.setName(dto.name());
        newStudent.setEmail(dto.email());

        return studentRepository.save(newStudent);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado."));
    }

    public List<CourseResponseDTO> findStudentCourses(Long id) {
        Student findedStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado."));

        List<CourseResponseDTO> courses = findedStudent.getEnrollments().stream().map(enrollment -> new CourseResponseDTO(enrollment.getId(), enrollment.getCourse().getTitle(), enrollment.getCourse().getDescription(), enrollment.getCourse().getTeacher().getName())).toList();
        return courses;
    }
}
