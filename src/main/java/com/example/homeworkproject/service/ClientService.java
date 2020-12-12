package com.example.homeworkproject.service;

import com.example.homeworkproject.repo.ClientRepository;
import com.example.homeworkproject.repo.entity.ClientEntity;
import com.example.homeworkproject.repo.entity.DiseaseEntity;
import com.example.homeworkproject.repo.entity.DoctorEntity;
import com.example.homeworkproject.repo.entity.DrugEntity;
import com.example.homeworkproject.service.dto.ClientDto;
import com.example.homeworkproject.service.dto.DiseaseDto;
import com.example.homeworkproject.service.dto.DoctorDto;
import com.example.homeworkproject.service.dto.DrugDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private ConverterToDto converterToDto ;


    public List<ClientDto> findAll() {
        List<ClientDto> list = StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .map(entity -> ClientDto.builder()
                        .firstName(entity.getFirstName())
                        .lastName(entity.getLastName())
                        .gender(entity.getGender())
                        .email(entity.getEmail())
                        .telNumber(entity.getTelNumber())
                        .doctor(toDto(entity.getDoctor()))
                        .disease(toDto(entity.getDisease()))
                        .build())
                .collect(Collectors.toList());
//        if (list.isEmpty()) {
//            log.warn();
//            throw new Exception("");
//        }
        return list;
    }

    public void save(ClientDto clientDto) {
        ClientEntity.builder()
                .firstName(clientDto.getFirstName().toUpperCase())
                .lastName(clientDto.getLastName().toUpperCase())
                .gender(clientDto.getGender())
                .email(clientDto.getEmail())
                .telNumber(clientDto.getTelNumber())
                .build();
    }

    public boolean deleteById(String id) {
        clientRepository.deleteById(Long.valueOf(id));
        log.info("Deleted 1 row");
        return true;
    }

    public void getUser(String firstName) {
        Optional<ClientEntity> user = clientRepository.findByFirstName(firstName);
        log.info(user.get().toString());
    }
    DoctorDto toDto(DoctorEntity entity) {
        return DoctorDto.builder()
                .firstName(entity.getFirst_name())
                .lastName(entity.getLast_name())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .build();
    }

    DiseaseDto toDto(DiseaseEntity entity) {
        return DiseaseDto.builder()
                .diagnosisCode(entity.getDiagnosisCode())
                .drug(toDto(entity.getDrug()))
                .build();
    }

    DrugDto toDto(DrugEntity entity) {
        return DrugDto.builder()
                .brand(entity.getBrand())
                .generic(entity.getGeneric())
                .drugCompany(entity.getDrugCompany())
                .price(entity.getPrice())
                .build();
    }

}
