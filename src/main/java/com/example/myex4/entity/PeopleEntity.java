package com.example.myex4.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "people")
public class PeopleEntity {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private List<String> favColors; // Составное поле
}
