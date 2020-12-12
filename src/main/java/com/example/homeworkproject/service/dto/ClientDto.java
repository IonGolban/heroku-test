package com.example.homeworkproject.service.dto;

import com.example.homeworkproject.repo.entity.DiseaseEntity;
import com.example.homeworkproject.repo.entity.DoctorEntity;
import com.example.homeworkproject.service.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    private String firstName;

    private String lastName;

    private GenderType gender;

    private String email;

    private String telNumber;

    private DoctorDto doctor;

    private DiseaseDto disease;

}
