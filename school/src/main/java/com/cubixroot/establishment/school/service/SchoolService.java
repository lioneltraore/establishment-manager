package com.cubixroot.establishment.school.service;


import com.cubixroot.establishment.school.config.client.StudentClient;
import com.cubixroot.establishment.school.domain.School;
import com.cubixroot.establishment.school.domain.dto.FullSchoolDTO;
import com.cubixroot.establishment.school.domain.dto.StudentDTO;
import com.cubixroot.establishment.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolDTO findSchoolWithStudents(Integer schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());

        List<StudentDTO> students = studentClient.findAllStudentsBySchool(schoolId);

        return FullSchoolDTO.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
