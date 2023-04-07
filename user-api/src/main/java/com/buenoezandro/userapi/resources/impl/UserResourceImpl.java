package com.buenoezandro.userapi.resources.impl;

import com.buenoezandro.userapi.domain.User;
import com.buenoezandro.userapi.resources.UserResource;
import com.buenoezandro.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
@RestController
public class UserResourceImpl implements UserResource {
    private final UserService userService;

    @Override
    public ResponseEntity<User> findById(Long id) {
        return ok(this.userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ok(this.userService.findAll());
    }
}
