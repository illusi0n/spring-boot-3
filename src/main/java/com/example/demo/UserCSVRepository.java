package com.example.demo;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserCSVRepository {

    public Optional<User> findByFirstName(String firstName) throws IOException {
        return findAllUsers().stream().filter(user -> user.getFirstName().equals(firstName)).findFirst();
    }

    private List<User> findAllUsers() throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("data/random_names.csv").getInputStream()));
        CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader).withType(User.class).withIgnoreLeadingWhiteSpace(true).build();
        List<User> users = csvToBean.parse();
        return users;
    }
}
