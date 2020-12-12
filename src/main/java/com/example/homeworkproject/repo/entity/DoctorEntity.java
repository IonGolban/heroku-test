package com.example.homeworkproject.repo.entity;

import com.example.homeworkproject.service.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_DOCTORS")
public class DoctorEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String first_name;

    @Column(name = "lastName")
    private String last_name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @Column(name = "email")
    private String email;


}
