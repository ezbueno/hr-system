package com.buenoezandro.userapi.config;

import com.buenoezandro.userapi.domain.User;
import com.buenoezandro.userapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.List.of;

@RequiredArgsConstructor
@Configuration
public class UserConfig {
    private final UserRepository userRepository;

    @Bean
    public void createUSer() {
        this.userRepository.saveAll(of(new User(null, "Ezandro", "ezandro@teste.com", "123", 20.0)));
    }
}
