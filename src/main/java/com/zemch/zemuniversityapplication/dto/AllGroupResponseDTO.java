package com.zemch.zemuniversityapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllGroupResponseDTO {
    Long id;
    String name;
    int studentQuantity;
}
