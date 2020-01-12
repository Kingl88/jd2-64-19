package by.it.academy.design_bureau.web.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.stream.Stream;

public class CookieUtils {

    private static final String AUTH_USER_COOKIE_NAME = "design_bureau_user_id"; // название cookie.
    public static final int MAX_AGE_24H = 24 * 60 * 60; // время хранения cookie.

    public static void storeUserCookie(HttpServletResponse response, Long userId) { // метод для создания истории cookie.
        Cookie cookie = new Cookie(AUTH_USER_COOKIE_NAME, String.valueOf(userId)); // создаем cookie с названием "AUTH_USER_COOKIE_NAME" и значением "userId".
        cookie.setMaxAge(MAX_AGE_24H); // устанавливаем время хранения cookie.
        response.addCookie(cookie); // установка cookie.
    }

    public static Optional<Long> getAuthUserId(HttpServletRequest request) { // метод получения IdUser'a из массива полученных cookie.
        Cookie[] cookies = request.getCookies(); // получаем массив всех cookie.
        if (cookies == null) {
            return Optional.empty(); // возвращаем пустой объект.
        } else {
            return Stream.of(cookies) //создаем поток
                    .filter(c -> c.getName().equals(AUTH_USER_COOKIE_NAME)) // фильтруем по названию необходимого cookie.
                    .map(Cookie::getValue) // преобразуем поток Cookie в поток String значений cookie.
                    .filter(StringUtils::isNumeric) // фильтр-проверка является значение числовым или нет.
                    .map(Long::valueOf) // преобразуем поток String значений cookie в поток преобразованных значений value в Long.
                    .findFirst(); // возвращаем первое значение из потока.
        }
    }

    public static void removeCookie(HttpServletResponse response) { // метод удаления cookie.
        Cookie cookie = new Cookie(AUTH_USER_COOKIE_NAME, null); // создаем cookie с названием "AUTH_USER_COOKIE_NAME" и значением "null".
        cookie.setMaxAge(0); // устанавливаем время хранения cookie.
        response.addCookie(cookie); // установка cookie.
    }
}
