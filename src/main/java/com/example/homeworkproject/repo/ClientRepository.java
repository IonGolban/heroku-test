package com.example.homeworkproject.repo;

import com.example.homeworkproject.repo.entity.ClientEntity;
import com.example.homeworkproject.service.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
@EnableJpaRepositories
public interface ClientRepository extends CrudRepository<ClientEntity,Long> {

    Optional<ClientEntity> findByFirstName(String firstName);

}
