package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserCSVRepository userRepository;

    @GetMapping(path = "/findByFirstName")
    public User findUserByFirstName(@RequestParam("firstName") String firstName) throws IOException {
        Optional<User> findUserResult = this.userRepository.findByFirstName(firstName);
        if (findUserResult.isEmpty()) {
            throw new IllegalArgumentException(String.format("User with firstName=%s not found.", firstName));
        }

        return findUserResult.get();
    }
}
