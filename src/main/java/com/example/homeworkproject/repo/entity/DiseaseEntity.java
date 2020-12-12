package com.example.homeworkproject.repo.entity;

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
@Table(name = "T_DISEASES")
public class DiseaseEntity {

    @Id
    @Column(name = "id")
    private Long id ;

    @Column(name = "diagnosis_code")
    private String diagnosisCode ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id", insertable = false, updatable = false)
    private DrugEntity drug ;



}
