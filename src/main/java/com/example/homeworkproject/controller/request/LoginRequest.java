package com.example.homeworkproject.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Validated
public class LoginRequest {

    @Size(max = 20, min = 4, message = "firstname should be between 4 and 20 characters")
    private String firstName;

    @Size(max = 20, min = 4, message = "password should be between 4 and 20 characters")
    @Pattern(regexp = "[a-z]{4,40}[0-1]{}")
    private String password;
}
