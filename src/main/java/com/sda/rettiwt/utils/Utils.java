package com.sda.rettiwt.utils;

import com.sda.rettiwt.hibernate.dao.UserDao;
import com.sda.rettiwt.hibernate.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class Utils {

    public final static String USER_COOKIE_NAME = "userCookie";

    private Utils() {

    }

    public static Optional<User> getUserFromCookies(final HttpServletRequest req) {

        Optional<Cookie> first = Arrays.stream(req.getCookies())
                .filter(cookie -> USER_COOKIE_NAME.equals(cookie.getName()))
                .findFirst();

        if (first.isPresent()) {
            String idFromCookie = first.get().getValue();

            Optional<List<User>> userList = UserDao.getInstance().getAll();
            Optional<User> usersList = userList.get()
                    .stream()
                    .filter(user -> idFromCookie.equals(String.valueOf(user.getId())))
                    .findFirst();
            if (usersList.isPresent()){
                return usersList;
            }
        }

        return Optional.empty();
    }
}
