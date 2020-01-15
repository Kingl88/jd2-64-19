package by.it.academy.design_bureau.web.servlet;

import by.it.academy.design_bureau.model.Employee;
import by.it.academy.design_bureau.service.EmployeeService;
import by.it.academy.design_bureau.service.impl.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user/employeeList", "/admin/employeeList"})
public class EmployeeListServlet extends HttpServlet {
    private EmployeeService serviceEmployee = EmployeeServiceImp.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> allEmployee = serviceEmployee.getAll();
        req.setAttribute("employeeList", allEmployee);
        req.getRequestDispatcher("/WEB-INF/jsp/employee/employeeList.jsp").forward(req,resp);
    }
}
