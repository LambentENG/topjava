package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User(1, "Динора Янбарисова", "creatingreality@gmail.com", "37_kOWer873!fsgeeg44556jenesuispas!!!!", Role.ROLE_ADMIN),
            new User(1201, "Евгения Лижненко", "smartandbeauty@zhenya.com", "123jet'aime", Role.ROLE_USER),
            new User(1919, "Анастасия Семенова", "nastya@yandex.ru", "kotikiSoba4ki", Role.ROLE_USER)

    );


}
