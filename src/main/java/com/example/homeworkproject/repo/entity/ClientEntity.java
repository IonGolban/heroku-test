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
@Table(name = "T_CLIENT")
public class ClientEntity {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "clientSeq", sequenceName = "t_client_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "clientSeq", strategy = GenerationType.SEQUENCE)
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
