package br.com.wfincatti.jwtrestapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CredentialsRequest {
    private String username;
    private String password;
}
