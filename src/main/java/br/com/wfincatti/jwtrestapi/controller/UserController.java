package br.com.wfincatti.jwtrestapi.controller;

import br.com.wfincatti.jwtrestapi.entity.User;
import br.com.wfincatti.jwtrestapi.service.ListUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ListUsers listUsers;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(listUsers.execute());
    }
}
