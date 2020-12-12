package com.example.homeworkproject.service.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@Builder
@ToString
public class ClientDetailsDto {
    List<ClientAuthorityDto> authorities ;

    private String password;

    private String firstName;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

}
