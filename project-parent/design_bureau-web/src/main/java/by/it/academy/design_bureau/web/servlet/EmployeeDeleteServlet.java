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

@WebServlet(urlPatterns = "/del_employee")
public class EmployeeDeleteServlet extends HttpServlet {
    private final Service<Employee> serviceEmployee = EmployeeServiceImp.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        serviceEmployee.delete(Long.parseLong(id));
        resp.sendRedirect(req.getContextPath() + "/employeeList");
    }

}
