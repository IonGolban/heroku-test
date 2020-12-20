package com.example.homeworkproject.service.auth;

import com.example.homeworkproject.repo.ClientRepository;
import com.example.homeworkproject.repo.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientDetailsImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        Optional<ClientEntity> foundClient = clientRepository.findByFirstName(firstName);

        if (foundClient.isPresent()) {
            return (UserDetails) ClientDetailsConverter.apply(foundClient.get());
        }

        throw new UsernameNotFoundException("firstname :" + firstName + " is not found");
    }

}
