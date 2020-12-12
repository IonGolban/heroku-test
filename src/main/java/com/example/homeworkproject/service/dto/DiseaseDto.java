package com.example.homeworkproject.service.dto;

import com.example.homeworkproject.repo.entity.DrugEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiseaseDto {

    private String diagnosisCode;

    private DrugDto drug;

}
