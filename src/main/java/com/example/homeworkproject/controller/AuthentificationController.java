package com.example.homeworkproject.controller;

import com.example.homeworkproject.controller.request.LoginRequest;
import com.example.homeworkproject.controller.response.LoginResponse;
import com.example.homeworkproject.service.auth.ClientDetailsImpl;
import com.example.homeworkproject.service.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthentificationController {

    private final JwtUtil jwtUtil;

    private final ClientDetailsImpl clientDetailsService;

    private final AuthenticationManager authenticationManager;


    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login( @Valid @RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getFirstName();
        String password = loginRequest.getPassword();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);

        try {
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            log.warn("Invalid user and pass");
            return ResponseEntity.badRequest().build();
        }

        UserDetails userDetails = clientDetailsService.loadUserByUsername(username);
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
