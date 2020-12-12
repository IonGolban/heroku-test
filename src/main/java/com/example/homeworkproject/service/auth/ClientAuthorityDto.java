package com.example.homeworkproject.service.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
@Getter
@Setter
@Builder
@ToString
public class ClientAuthorityDto implements GrantedAuthority {
    private String authority;

}
