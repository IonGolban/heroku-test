package com.example.homeworkproject.service.util;

import com.example.homeworkproject.repo.entity.DiseaseEntity;
import com.example.homeworkproject.repo.entity.DrugEntity;
import com.example.homeworkproject.service.dto.DiseaseDto;
import com.example.homeworkproject.service.dto.DrugDto;


public class DrugConverter {

    public static DrugDto toDrugDto(DrugEntity entity) {
        return DrugDto.builder()
                .brand(entity.getBrand())
                .generic(entity.getGeneric())
                .drugCompany(entity.getDrugCompany())
                .price(entity.getPrice())
                .build();
    }

}
