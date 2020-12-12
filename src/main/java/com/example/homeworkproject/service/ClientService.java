package com.example.homeworkproject.service;

import com.example.homeworkproject.repo.ClientRepository;
import com.example.homeworkproject.repo.entity.ClientEntity;
import com.example.homeworkproject.service.dto.ClientDto;
import com.example.homeworkproject.service.exception.ClientNotFoundException;
import com.example.homeworkproject.service.util.ClientConverter;
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

    private ClientConverter clientConverter;


    public List<ClientDto> findAll() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .map(ClientConverter::toClientDto)
                .collect(Collectors.toList());
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

    public ClientDto getUser(String firstName) {
        Optional<ClientEntity> user = clientRepository.findByFirstName(firstName);
        return user.map(ClientConverter::toClientDto).orElseThrow(ClientNotFoundException::new);
    }


}
