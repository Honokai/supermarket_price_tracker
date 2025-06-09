package com.sample.rest.Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sample.rest.Application.Utils.JwtUtil;
import com.sample.rest.Domain.Entities.User;
import com.sample.rest.Domain.Interfaces.IUserRepository;
import com.sample.rest.WebApi.DTO.Auth.LoginRequestRecord;
import com.sample.rest.WebApi.DTO.Auth.LoginResponseRecord;
import com.sample.rest.WebApi.DTO.Auth.SignUpRequestRecord;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(SignUpRequestRecord request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        // user.setRole("USER");  // padrão
        // user.setEnabled(true);

        userRepository.save(user);
    }

    public LoginResponseRecord authenticate(LoginRequestRecord request) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        String token = jwtUtil.generateToken(auth.getName());

        return new LoginResponseRecord(token);
    }
}
