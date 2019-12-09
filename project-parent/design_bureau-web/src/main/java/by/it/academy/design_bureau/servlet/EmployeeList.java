package by.it.academy.design_bureau.servlet;

import by.it.academy.design_bureau.model_bureau.Employee;
import by.it.academy.design_bureau.service.Service;
import by.it.academy.design_bureau.service.ServiceEmployeeImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/employeeList")
public class EmployeeList extends HttpServlet {
    private Service<Employee> serviceEmployee = ServiceEmployeeImp.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> allEmployee = serviceEmployee.getAll();
        req.setAttribute("employeeList", allEmployee);
        req.getRequestDispatcher("/WEB-INF/jsp/employeeList.jsp").forward(req,resp);
    }
}
