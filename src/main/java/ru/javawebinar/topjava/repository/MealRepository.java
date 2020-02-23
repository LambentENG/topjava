package ru.javawebinar.topjava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;


public interface MealRepository {
    // null if not found, when updated
    Meal save(Meal meal, Integer userId);

    // false if not found
    boolean delete(int id, Integer userId);

    // null if not found
    Meal get(int id, Integer userId);

    List<Meal> getAll(Integer userId);

    List<Meal> getAllFromTo(LocalDateTime from, LocalDateTime to, Integer userId);
}
