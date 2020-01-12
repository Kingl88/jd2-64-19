package by.it.academy.design_bureau.web.filter;

import by.it.academy.design_bureau.model.Employee;
import by.it.academy.design_bureau.service.EmployeeService;
import by.it.academy.design_bureau.service.impl.EmployeeServiceImp;
import by.it.academy.design_bureau.web.dto.UserAccount;
import by.it.academy.design_bureau.web.util.CookieUtils;
import by.it.academy.design_bureau.web.util.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST) // Почему именно "DispatcherType.REQUEST"???
public class CookieFilter extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(CookieFilter.class);
    private static final EmployeeService employeeService = EmployeeServiceImp.getService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (!SessionUtils.getUserAccount(req).isPresent()) { // проверяем есть ли в сессии залогинившийся юзер.
            /* если юзера нету, то получаем Id юзера из куки, с помощью "getAuthUserId"
            с помощью "flatMap(employeeService::getEmployeeById)" пытаемся получить объект Optional<Employee>
            проверяем существует ли такой объект "ifPresent", если да то добавляем этого юзера в сессию. */
            CookieUtils.getAuthUserId(req).flatMap(employeeService::getEmployeeById)
                    .ifPresent(e -> addUserToSession(req, e));

        }
        super.doFilter(req, res, chain);
    }

    private void addUserToSession(HttpServletRequest req, Employee e) { // метод добавления юзера из куки в сессию.
        UserAccount user = new UserAccount(e);
        SessionUtils.setUserSession(req, user);
        logger.info("User restored from cookie; {}", user);
    }
}
