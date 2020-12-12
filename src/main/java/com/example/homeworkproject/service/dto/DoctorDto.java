package com.example.homeworkproject.service.dto;

import com.example.homeworkproject.repo.entity.DoctorEntity;
import com.example.homeworkproject.service.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DoctorDto {


    private String firstName;

    private String lastName;

    private GenderType gender;

    private String email;



}
