package com.cubixroot.establishment.school.controller;

import com.cubixroot.establishment.school.domain.School;
import com.cubixroot.establishment.school.domain.dto.FullSchoolDTO;
import com.cubixroot.establishment.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getSchool() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("with-students/{school-id}")
    public FullSchoolDTO findSchoolWithStudents(@PathVariable("school-id") Integer schoolId) {
        return schoolService.findSchoolWithStudents(schoolId);
    }

}
