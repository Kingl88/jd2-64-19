package by.it.academy.design_bureau.web.servlet;

import by.it.academy.design_bureau.model.Employee;
import by.it.academy.design_bureau.service.EmployeeService;
import by.it.academy.design_bureau.service.EmployeeServiceImp;
import by.it.academy.design_bureau.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
private final EmployeeService employeeService = EmployeeServiceImp.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).setAttribute("design_bureau.Locale", "ru");
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String rememberMeStr = req.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);

        String errorMsg = "";
        boolean hasError = false;

        if (userName == null || userName.length() == 0 || password == null || password.length() == 0) {
            hasError = true;
            errorMsg = "UserName and password should not be empty; ";
        } else {
            Optional<Employee> user = employeeService.findUser(userName, password);
            if (user.isEmpty()) {
                hasError = true;
                errorMsg = "Invalid user name or password";
            } else {
                req.getSession().setAttribute("user", user.get());
            }
        }

        if (hasError) {
            req.setAttribute("errorString", errorMsg);
            req.setAttribute("userName", userName);
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
