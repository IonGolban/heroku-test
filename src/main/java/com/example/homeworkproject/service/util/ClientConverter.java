package com.example.homeworkproject.service.util;

import com.example.homeworkproject.repo.entity.ClientEntity;
import com.example.homeworkproject.service.dto.ClientDto;

import static com.example.homeworkproject.service.util.DiseaseConverter.toDiseaseDto;
import static com.example.homeworkproject.service.util.DoctorConverter.toDoctorDto;


public class ClientConverter {

    public static ClientDto toClientDto(ClientEntity entity) {
        return ClientDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .telNumber(entity.getTelNumber())
                .doctor(toDoctorDto(entity.getDoctor()))
                .disease(toDiseaseDto(entity.getDisease()))
                .build();
    }

}
