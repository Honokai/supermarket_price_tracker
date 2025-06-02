package com.sample.rest.WebApi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sample.rest.Domain.Entities.User;
import com.sample.rest.Domain.Interfaces.IUserRepository;
import com.sample.rest.WebApi.Request.ApiResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> index() {
        var response = new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ApiResponse<Boolean> create() {
        var response = new ApiResponse("Created", null);
        
        return response;
    }
}
