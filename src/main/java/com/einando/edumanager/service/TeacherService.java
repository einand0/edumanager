package com.einando.edumanager.service;

import com.einando.edumanager.dto.TeacherRequestDTO;
import com.einando.edumanager.entity.Teacher;
import com.einando.edumanager.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(TeacherRequestDTO dto) {
        Teacher newTeacher = new Teacher();
        newTeacher.setName(dto.name());
        newTeacher.setSpeciality(dto.speciality());

        return teacherRepository.save(newTeacher);
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado")
                );
    }
}
