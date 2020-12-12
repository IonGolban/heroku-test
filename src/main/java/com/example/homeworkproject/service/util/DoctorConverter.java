package com.example.homeworkproject.service.util;

import com.example.homeworkproject.repo.entity.ClientEntity;
import com.example.homeworkproject.repo.entity.DoctorEntity;
import com.example.homeworkproject.service.dto.ClientDto;
import com.example.homeworkproject.service.dto.DoctorDto;


public class DoctorConverter {

    public static DoctorDto toDoctorDto(DoctorEntity entity) {
        return DoctorDto.builder()
                .firstName(entity.getFirst_name())
                .lastName(entity.getLast_name())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .build();
    }

}
