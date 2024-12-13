package com.example.myex4.controller;

import com.example.myex4.entity.PeopleEntity;
import com.example.myex4.repository.PeopleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    // GET: Получить всех людей
    @GetMapping("/getPeople")
    public List<PeopleEntity> getPeople() {
        return peopleRepository.findAll();
    }

    // POST: Добавить человека
    @PostMapping("/addPerson")
    public String addPerson(@RequestBody PeopleEntity person) {
        // Сохранение объекта в MongoDB через репозиторий
        peopleRepository.save(person);
        return "Человек успешно добавлен!";
    }

    // DELETE: Удалить человека по ID
    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable String id) {
        if (peopleRepository.existsById(id)) {
            peopleRepository.deleteById(id);
            return "Человек успешно удалён!";
        } else {
            return "Человек с указанным ID не найден.";
        }
    }

    // GET: Найти человека по ID
    @GetMapping("/getPerson/{id}")
    public PeopleEntity getPersonById(@PathVariable String id) {
        return peopleRepository.findById(id).orElse(null);
    }

    // GET: Найти человека по телефону
    @GetMapping("/getPersonByPhone/{phone}")
    public PeopleEntity getPersonByPhone(@PathVariable String phone) {
        return peopleRepository.findByPhone(phone);
    }

    @GetMapping("/getPeopleByColor")
    public List<PeopleEntity> getPeopleByColor(@RequestParam String color) {
        return peopleRepository.findByFavColorsContaining(color);
    }
}
