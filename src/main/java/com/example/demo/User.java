package com.example.demo;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
    @CsvBindByName
    private String firstName;
    @CsvBindByName
    private String lastName;
}
