package com.example.homeworkproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrugDto {

    private String brand;

    private String generic;

    private String drugCompany;

    private String price;
}
