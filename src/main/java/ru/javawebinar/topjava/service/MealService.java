package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;

import java.time.LocalDateTime;
import java.util.List;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;
import static ru.javawebinar.topjava.util.MealsUtil.getTos;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, Integer userId) {
        return repository.save(meal, userId);
    }

    public void delete(int id, Integer userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Meal get(int id, Integer userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public List<MealTo> getAll(Integer userId) {
        return getTos(repository.getAll(userId), DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealTo> getAllFromTo(LocalDateTime from, LocalDateTime to, Integer userId) {
        return getTos(repository.getAllfromTo(from, to, userId), DEFAULT_CALORIES_PER_DAY);
    }

    public void update(Meal meal, Integer userId) {
        checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }
}