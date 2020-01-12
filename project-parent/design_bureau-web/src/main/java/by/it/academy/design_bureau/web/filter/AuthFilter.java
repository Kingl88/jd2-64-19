package by.it.academy.design_bureau.web.filter;

import by.it.academy.design_bureau.web.dto.UserAccount;
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
import java.util.Optional;

@WebFilter(urlPatterns = {"/user/*", "/admin/*"}, dispatcherTypes = DispatcherType.REQUEST) // пропускаем все, кроме того что указано в паттерне.
public class AuthFilter extends HttpFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.debug("Auth filter");
        Optional<UserAccount> userAccount = SessionUtils.getUserAccount(req); // создаем объект взятый из сессии.
        if (userAccount.isPresent()) { // если вход произведен то пропускаем дальше на страницы (userAccount не пустой).
            super.doFilter(req, res, chain);
        } else {
            res.sendRedirect(req.getContextPath() + "/login"); // если вход не выполнен кидаем на страницу логина.
        }
    }
}
