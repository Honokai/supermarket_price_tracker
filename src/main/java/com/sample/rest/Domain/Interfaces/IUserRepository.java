package com.sample.rest.Domain.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.rest.Domain.Entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    
}
