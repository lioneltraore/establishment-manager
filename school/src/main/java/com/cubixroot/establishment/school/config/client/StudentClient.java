package com.cubixroot.establishment.school.config.client;

import com.cubixroot.establishment.school.domain.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient( name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("school/{school-id}")
    public List<StudentDTO> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);

}
