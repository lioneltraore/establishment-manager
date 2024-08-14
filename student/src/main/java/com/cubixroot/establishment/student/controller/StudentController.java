package com.cubixroot.establishment.student.controller;

import com.cubixroot.establishment.student.domain.Student;
import com.cubixroot.establishment.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("school/{school-id}")
    public List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId) {
        return studentService.findAllStudentsBySchool(schoolId);
    }

}
