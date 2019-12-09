package by.it.academy.design_bureau.servlet;

import by.it.academy.design_bureau.model_bureau.Drawing;
import by.it.academy.design_bureau.model_bureau.Employee;
import by.it.academy.design_bureau.service.Service;
import by.it.academy.design_bureau.service.ServiceDrawing;
import by.it.academy.design_bureau.service.ServiceEmployee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/drawingCreate")
public class DrawingCreateServlet extends HttpServlet {
    private Service<Drawing> serviceDrawing = ServiceDrawing.getService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String designation = req.getParameter("designation");
        Employee developed = ServiceEmployee.getEmployeeByLastName(req.getParameter("developed"));
        Employee checked = ServiceEmployee.getEmployeeByLastName(req.getParameter("checked"));
        Employee approved = ServiceEmployee.getEmployeeByLastName(req.getParameter("approved"));
        String isAssembly = req.getParameter("isAssembly");
        Drawing drawing = new Drawing(null, name, designation, developed, checked, approved,
                isAssembly.equals("true"));
        serviceDrawing.addNew(drawing);
        resp.sendRedirect(req.getContextPath() + "/drawingList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/drawingCreate.jsp").forward(req, resp);


    }
}
