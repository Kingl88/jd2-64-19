package by.it.academy.design_bureau.web.util;

import by.it.academy.design_bureau.web.dto.UserAccount;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class SessionUtils {

    public static final String SESSION_ATTR_NAME = "auth_user"; // название сессии.

    public static void setUserSession(HttpServletRequest request, UserAccount user) {
        request.getSession().setAttribute(SESSION_ATTR_NAME, user); // устанавливаем название сессии "SESSION_ATTR_NAME" для юзера залогиневшегося в системе.
    }

    public static Optional<UserAccount> getUserAccount(HttpServletRequest request) {
        /*пытаемся получить объект с помощью запроса по названию сессии, если получили объект
        то приводим его к "UserAccount", в противном случае сессия пустая, т.е. никто не залогинился*/
        return Optional.ofNullable((UserAccount) request.getSession().getAttribute(SESSION_ATTR_NAME));

    }
}
