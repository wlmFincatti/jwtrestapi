package br.com.wfincatti.jwtrestapi.service;

import br.com.wfincatti.jwtrestapi.entity.User;
import br.com.wfincatti.jwtrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsers {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public List<User> execute() {
        return userRepository.findAll(Sort.by("username"));
    }
}
