package com.buenoezandro.userapi.services.impl;

import com.buenoezandro.userapi.domain.User;
import com.buenoezandro.userapi.repositories.UserRepository;
import com.buenoezandro.userapi.services.UserService;
import com.buenoezandro.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
