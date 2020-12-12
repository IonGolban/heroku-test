package com.example.homeworkproject.repo.entity;

import com.example.homeworkproject.service.dto.DoctorDto;
import com.example.homeworkproject.service.type.GenderType;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_CLIENT")
public class ClientEntity {
    @Id
    @Column(name = "id")
    //@SequenceGenerator()
    //@GeneratedValue
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_number")
    private String telNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disease_id", insertable = false, updatable = false)
    private DiseaseEntity disease;

}
