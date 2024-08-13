package com.cubixroot.establishment.school.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolDTO {

    private String name;
    private String email;
    private List<StudentDTO> students;
}
