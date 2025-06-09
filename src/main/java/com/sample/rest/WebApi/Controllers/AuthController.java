package com.sample.rest.WebApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rest.Application.Services.AuthenticationService;
import com.sample.rest.WebApi.DTO.Auth.LoginRequestRecord;
import com.sample.rest.WebApi.DTO.Auth.LoginResponseRecord;
import com.sample.rest.WebApi.DTO.Auth.SignUpRequestRecord;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponseRecord> authenticate(@RequestBody LoginRequestRecord loginRequest) {
        var token = authenticationService.authenticate(loginRequest);
        
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestRecord requestRecord) {
        System.out.println(requestRecord);
        authenticationService.signup(requestRecord);

        return ResponseEntity.ok().body("Usuario registrado com sucesso");
    }
}
