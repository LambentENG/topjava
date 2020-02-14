package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface CRUDinterface {
    void createMeal(Meal meal);
    Meal getMealInfo (int mealId);
    List<Meal> getAllMealsInfo();
    void updateMealInfo(Meal meal);
    void deleteMealInfo(int mealId);
}
