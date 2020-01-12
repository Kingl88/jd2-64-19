package by.it.academy.design_bureau.web.servlet;

import by.it.academy.design_bureau.service.EmployeeService;
import by.it.academy.design_bureau.service.impl.EmployeeServiceImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/del_employee")
public class EmployeeDeleteServlet extends HttpServlet {
    private final EmployeeService serviceEmployee = EmployeeServiceImp.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        serviceEmployee.delete(Long.parseLong(id));
        resp.sendRedirect(req.getContextPath() + "/admin/employeeList");
    }

}
