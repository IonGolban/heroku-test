package com.example.homeworkproject.service.auth;

import com.example.homeworkproject.repo.entity.ClientEntity;

public class ClientDetailsConverter {
    public static ClientDetailsDto apply(ClientEntity entity) {
        return ClientDetailsDto.builder()
                .password(entity.getPassword())
                .firstName(entity.getFirstName())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }
}
