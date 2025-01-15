package com.example.myex4.controller;

import com.example.myex4.entity.PeopleEntity;
import com.example.myex4.repository.PeopleRepository;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/v1")
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    // POST : Добавить студента
    // в postman заполнять через body -> raw
    @PostMapping("/addStudent")
    public String addPerson(@RequestBody PeopleEntity student) {
        // Сохранение объекта в MongoDB через репозиторий
        peopleRepository.save(student);
        return "Данные успешно добавлены!";
    }

    // DELETE: Удалить студента по ID
    @DeleteMapping("/deleteStudent/{id}")
    public String deletePerson(@PathVariable String id) {
        if (peopleRepository.existsById(id)) {
            peopleRepository.deleteById(id);
            return "Даннные успешно удалены!";
        } else {
            return "Студент с указанным ID не найден.";
        }
    }

    // PUT: Обновить данные о форме обучеения студента
    // в postman заполнять через params
    @PutMapping("/updateEducationForm/{id}")
    public String updateEducationForm(@PathVariable String id, @RequestParam String educationForm) {
        if (peopleRepository.existsById(id)) {
            PeopleEntity student = peopleRepository.findById(id).orElse(null);
            if (student != null) {
                student.setEducationForm(educationForm);
                peopleRepository.save(student);
                return "Форма обучения успешно обновлена!";
            } else {
                return "Студент с указанным ID не найден.";
            }
        } else {
            return "Студент с указанным ID не существует.";
        }
    }

    // GET: Найти студента по номеру студенсечкого билета
    @GetMapping("/getStudentByStudentCard/{card}")
    public PeopleEntity getStudentByStudentCard(@PathVariable int card) {
        return peopleRepository.findByStudentCard(card);
    }

    // GET: Найти студента по группе
    @GetMapping("/getStudentByGroup/{group}")
    public PeopleEntity getStudentByGroup(@PathVariable String group) {
        return peopleRepository.findByGroup(group);
    }
}
