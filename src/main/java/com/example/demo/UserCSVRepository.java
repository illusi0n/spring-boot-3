package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class UserCSVRepository {

    public Optional<User> findByFirstName(String firstName) {
        return findAllUsers().stream().filter(user -> user.firstName().equals(firstName)).findFirst();
    }

    private List<User> findAllUsers() {
        return List.of(
                User.of("Abigail", "Cantu"),
                User.of("Julie", "Cook"),
                User.of("Jeffre", "Bailey"),
                User.of("Ralph", "Young"),
                User.of("Natasha", "Carter")
        );
    }
}
