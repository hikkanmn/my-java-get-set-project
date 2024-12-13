package com.example.myex4.repository;

import com.example.myex4.entity.PeopleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends MongoRepository<PeopleEntity, String> {
    PeopleEntity findByPhone(String phone); // Поиск по номеру телефона
    //Поиск людей по любому из любимых цветов
    List<PeopleEntity> findByFavColorsContaining(String color);
}
