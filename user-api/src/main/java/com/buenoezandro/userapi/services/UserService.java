package com.buenoezandro.userapi.services;

import com.buenoezandro.userapi.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();
}
