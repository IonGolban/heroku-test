package com.example.homeworkproject.service.util;

import com.example.homeworkproject.repo.entity.DiseaseEntity;
import com.example.homeworkproject.service.dto.DiseaseDto;

import static com.example.homeworkproject.service.util.DrugConverter.toDrugDto;


public class DiseaseConverter {

    public static DiseaseDto toDiseaseDto(DiseaseEntity entity) {
        return DiseaseDto.builder()
                .diagnosisCode(entity.getDiagnosisCode())
                .drug(toDrugDto(entity.getDrug()))
                .build();
    }

}
