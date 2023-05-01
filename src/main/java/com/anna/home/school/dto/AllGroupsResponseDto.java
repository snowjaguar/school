package com.anna.home.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllGroupsResponseDto {
    private Integer id;
    private String number;
    private int students;
}
