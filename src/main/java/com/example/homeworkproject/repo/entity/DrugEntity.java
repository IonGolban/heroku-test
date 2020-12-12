package com.example.homeworkproject.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_DRUGS")
public class DrugEntity {
    @Id
    @Column(name = "id")
   private Integer  id ;

    @Column(name = "brand")
   private String  brand ;

    @Column(name = "generic")
    private String  generic ;

    @Column(name = "drug_company")
   private String  drugCompany ;

    @Column(name = "price")
   private String  price ;
}
