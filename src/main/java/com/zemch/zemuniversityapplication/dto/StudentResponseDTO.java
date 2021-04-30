package com.zemch.zemuniversityapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    Long id;
    String name;
    String surname;
    LocalDate createAt;
}
