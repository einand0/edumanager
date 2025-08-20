package com.einando.edumanager.service;

import com.einando.edumanager.dto.CourseRequestDTO;
import com.einando.edumanager.entity.Course;
import com.einando.edumanager.entity.Teacher;
import com.einando.edumanager.repository.CourseRepository;
import com.einando.edumanager.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    public Course createCourse(CourseRequestDTO dto, Long id){

        Teacher findedTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado."));

        Course newCourse = new Course();
        newCourse.setTitle(dto.title());
        newCourse.setDescription(dto.description());
        newCourse.setTeacher(findedTeacher);

        return courseRepository.save(newCourse);
    }
}
