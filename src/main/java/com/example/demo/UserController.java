package com.example.demo;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserCSVRepository userRepository;

    private final ObservationRegistry observationRegistry;

    @GetMapping
    public User findUserByFirstName(@RequestParam("firstName") String firstName) {
        return Observation.createNotStarted("users.find", this.observationRegistry)
                .observe(() -> {
                    Optional<User> findUserResult = this.userRepository.findByFirstName(firstName);
                    if (findUserResult.isEmpty()) {
                        throw new IllegalArgumentException(String.format("User with firstName=%s not found.", firstName));
                    }

                    return findUserResult.get();
                });
    }
}
