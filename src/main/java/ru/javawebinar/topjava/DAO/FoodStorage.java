package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FoodStorage implements CRUDinterface {
    private final Map<Integer, Meal> foodStorage = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public void createMeal(Meal meal) {
        meal.setId(getCounter());
        foodStorage.put(meal.getId(), meal);
    }

    @Override
    public Meal getMealInfo(int mealId) {
        return null;
    }

    @Override
    public List<Meal> getAllMealsInfo() {
        return new ArrayList<>(foodStorage.values());
    }

    @Override
    public void updateMealInfo(Meal meal) {

    }

    @Override
    public void deleteMealInfo(int mealId) {

    }

    private int getCounter() {
        return counter.incrementAndGet();
    }
}
