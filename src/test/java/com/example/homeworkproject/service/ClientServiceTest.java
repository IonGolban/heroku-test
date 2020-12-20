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
import com.example.homeworkproject.service.exception.ClientNotFoundException;
import com.example.homeworkproject.service.type.GenderType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//UnitTest tests only a specific class/component and the other used components are mocked (ar redefined in test as we want)
@RunWith(SpringRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void getUserSuccessful() {
        when(clientRepository.findByFirstName(any()))
                .thenReturn(Optional.ofNullable(getClientEntity("name")));

        ClientDto expectedClient = getExpectedClient("name");

        ClientDto actualClient = clientService.getUser("name");

        assertEquals(actualClient, expectedClient);
    }

    @Test(expected = ClientNotFoundException.class)
    public void getUserNotFoundException() {
        when(clientRepository.findByFirstName(any()))
                .thenReturn(Optional.empty());

        clientService.getUser("name");
    }

    @Test
    public void findAllSuccessful() {
        String name1 = "name1qwe1r1";
        String name2 = "name2";
        List<ClientDto> expectedClient = new ArrayList<>();
        expectedClient.add(getExpectedClient(name1));
        expectedClient.add(getExpectedClient(name2));

        ArrayList<ClientEntity> mockedList = new ArrayList<>();
        mockedList.add(getClientEntity(name1));
        mockedList.add(getClientEntity(name2));
        when(clientRepository.findAll())
                .thenReturn(mockedList);

        List<ClientDto> actualClient = clientService.findAll();

        assertEquals(expectedClient, actualClient);
    }

    @Test
    public void findAllWithNoDataSuccessfulEmptyList() {
        String name1 = "name1qwe1r1";
        String name2 = "name2";
        Iterable<ClientEntity> mockedList = new ArrayList<>();
        Iterable<ClientDto> expectedClients = new ArrayList<>();

        when(clientRepository.findAll())
                .thenReturn(mockedList);

        List<ClientDto> actualClients = clientService.findAll();

        assertEquals(expectedClients, actualClients);
    }

    private ClientDto getExpectedClient(String name) {
        return ClientDto.builder()
                .firstName(name)
                .lastName("name")
                .gender(GenderType.FEMALE)
                .email("email@gmail.com")
                .telNumber("+456132789")
                .doctor(DoctorDto.builder().build())
                .disease(DiseaseDto.builder().drug(new DrugDto()).build())
                .build();
    }

    private ClientEntity getClientEntity(String name) {
        return ClientEntity.builder()
                .firstName(name)
                .lastName("name")
                .gender(GenderType.FEMALE)
                .email("email@gmail.com")
                .telNumber("+456132789")
                .doctor(DoctorEntity.builder().build())
                .disease(DiseaseEntity.builder().drug(new DrugEntity()).build())
                .build();
    }

}