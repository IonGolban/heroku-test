package com.example.homeworkproject.service.util;

import com.example.homeworkproject.repo.entity.ClientEntity;
import com.example.homeworkproject.service.dto.ClientDto;

import java.util.Optional;

import static com.example.homeworkproject.service.util.DiseaseConverter.toDiseaseDto;


public class ClientConverter {

    public static ClientDto toClientDto(ClientEntity entity) {
        return ClientDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .telNumber(entity.getTelNumber())
                .doctor(Optional.ofNullable(entity.getDoctor())
                        .map(DoctorConverter::toDoctorDto)
                        .orElse(null))
                .disease(Optional.ofNullable(entity.getDisease())
                        .map(DiseaseConverter::toDiseaseDto)
                        .orElse(null))
                .build();
    }

}
