package com.example.myex4.controller;

import com.example.myex4.entity.PeopleEntity;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class PeopleController {
    private final List<PeopleEntity> peopleList = new ArrayList<>();

    // GET метод для получения всех данных
    @GetMapping("/getPeople")
    public List<PeopleEntity> getPeople() {
        return peopleList;
    }

    // POST метод для добавления нового объекта
    @PostMapping("/addPerson")
    public String addPerson(@RequestBody PeopleEntity person) {
        peopleList.add(person);
        saveToFile(person);
        return "Человек успешно добавлен в файл people.txt!";
    }

    // Метод для сохранения данных в текстовый файл
    private void saveToFile(PeopleEntity person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("people.txt", true))) {
            writer.write("ID: " + person.getId() + ", Name: " + person.getName() +
                    ", Age: " + person.getAge() + ", Gender: " + person.getGender() +
                    ", Phone: " + person.getPhone() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
