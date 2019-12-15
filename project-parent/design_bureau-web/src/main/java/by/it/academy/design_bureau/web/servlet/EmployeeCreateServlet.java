package by.it.academy.design_bureau.web.servlet;

import by.it.academy.design_bureau.model.Employee;
import by.it.academy.design_bureau.service.EmployeeServiceImp;
import by.it.academy.design_bureau.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/employeeCreate")
public class EmployeeCreateServlet extends HttpServlet {
    private Service<Employee> serviceEmployee = EmployeeServiceImp.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/employee/employeeCreate.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String positionInCompany = req.getParameter("positionInCompany");
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        Employee employee = new Employee(null, firstName, lastName, positionInCompany, phoneNumber, password,
                login, false);
        serviceEmployee.addNew(employee);
        resp.sendRedirect(req.getContextPath() + "/employeeList");
    }
}
