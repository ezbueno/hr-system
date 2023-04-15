package com.buenoezandro.userapi.services.impl;

import com.buenoezandro.userapi.domain.User;
import com.buenoezandro.userapi.repositories.UserRepository;
import com.buenoezandro.userapi.services.UserService;
import com.buenoezandro.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Environment environment;

    @Override
    public User findById(Long id) {
        log.info("USER SERVICE ::: Get request on " + this.environment.getProperty("local.server.port") + " port");
        return this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
