package com.example.homeworkproject.controller;

import com.example.homeworkproject.controller.response.DeletedResponse;
import com.example.homeworkproject.service.ClientService;
import com.example.homeworkproject.service.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/clients", produces = "application/json")
    public ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> list = clientService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //  @RequestMapping(path = "/clients/{id}", produces = "application/json", method = RequestMethod.DELETE)
    //  public ResponseEntity<DeletedResponse> deleteBazz(@RequestParam String id) {
    //      boolean isDeleted = clientService.deleteById(id);
    //      return new ResponseEntity<>(new DeletedResponse(isDeleted), HttpStatus.OK);
    //  }
    @DeleteMapping("client/delete/{id}")
    public ResponseEntity<DeletedResponse> delete(@PathVariable String id) {
        boolean isDeleted = clientService.deleteById(id);
        return new ResponseEntity<>(new DeletedResponse(isDeleted), HttpStatus.OK);
    }

    @PutMapping(path = "clients", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDto> add(@RequestBody ClientDto client) {
        ClientDto clientDto = clientService.save(client);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping(path = "/clients/{firstName}", produces = "application/json")
    public ResponseEntity<List<String>> getUser(@PathVariable String firstName) {
        clientService.getUser(firstName);
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

}
