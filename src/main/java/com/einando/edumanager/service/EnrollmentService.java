package com.einando.edumanager.service;

import com.einando.edumanager.dto.EnrollmentRequestDTO;
import com.einando.edumanager.dto.EnrollmentResponseDTO;
import com.einando.edumanager.entity.Course;
import com.einando.edumanager.entity.Enrollment;
import com.einando.edumanager.entity.Student;
import com.einando.edumanager.repository.CourseRepository;
import com.einando.edumanager.repository.EnrollmentRepository;
import com.einando.edumanager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO dto){
        Student findedStudent = studentRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        Course findedCourse = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));

        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setEnrollmentDate(LocalDate.now());
        newEnrollment.setCourse(findedCourse);
        newEnrollment.setStudent(findedStudent);

        Enrollment savedEnrollment = enrollmentRepository.save(newEnrollment);

        return new EnrollmentResponseDTO(savedEnrollment.getId(), savedEnrollment.getEnrollmentDate(), savedEnrollment.getStudent().getName(), savedEnrollment.getCourse().getTitle());
    }
}
