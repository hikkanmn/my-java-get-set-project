package com.example.myex4.repository;

import com.example.myex4.entity.PeopleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface PeopleRepository extends MongoRepository<PeopleEntity, String> {
    PeopleEntity findByStudentCard(int StudentCard); // Поиск по номеру студ билета
    PeopleEntity findByGroup(String group); // Поиск по номеру группы

}
