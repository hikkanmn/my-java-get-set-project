package com.example.myex4.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import java.util.List;

@Getter
@Setter
@Document(collection = "students")
public class PeopleEntity {
    @Id
    // обязательные поля по заданию
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String group;
    private String educationForm;
    private String dateOfAdmission;
    // дополнительные 4 поля по заданию
    private int studentCard;
    private String dateOfBirth;
    private String gender;
    private String phone;
}
