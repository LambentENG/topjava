package ru.javawebinar.topjava.web;

import javax.servlet.http.HttpServlet;
import org.slf4j.Logger;
import ru.javawebinar.topjava.DAO.FoodStorage;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static FoodStorage foodStorage;


    public void init() {
        foodStorage = new FoodStorage();
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        foodStorage.createMeal(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("MealServlet doGet method");

        List<Meal> meals = foodStorage.getAllMealsInfo();
        List<MealTo> mealsTo = MealsUtil.filteredByStreams(meals, LocalTime.MIN, LocalTime.MAX, 2000);

        System.out.println(mealsTo);

        request.setAttribute("meals", mealsTo);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}




