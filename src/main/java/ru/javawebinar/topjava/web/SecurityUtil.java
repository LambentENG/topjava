package ru.javawebinar.topjava.web;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class SecurityUtil {

    private  static int loggedUserId = 1;

    public static int authUserId() {
        return loggedUserId;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }

    public static void setLoggedUserId(int loggedUserId) {
        SecurityUtil.loggedUserId = loggedUserId;
    }

    public static int getLoggedUserId() {
        return loggedUserId;
    }
}