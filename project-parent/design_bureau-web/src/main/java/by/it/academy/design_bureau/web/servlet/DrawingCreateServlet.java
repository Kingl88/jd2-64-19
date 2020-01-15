//package by.it.academy.design_bureau.web.servlet;
//
//import by.it.academy.design_bureau.model.Drawing;
//import by.it.academy.design_bureau.model.Employee;
//import by.it.academy.design_bureau.service.DrawingService;
//import by.it.academy.design_bureau.service.impl.EmployeeServiceImp;
//import by.it.academy.design_bureau.service.EmployeeService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/drawingCreate")
//public class DrawingCreateServlet extends HttpServlet {
//    private Service<Drawing> serviceDrawing = DrawingService.getService();
//    private EmployeeService employeeInterface = EmployeeServiceImp.getService();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String name = req.getParameter("name");
//        String designation = req.getParameter("designation");
//        Employee developed = employeeInterface.getEmployeeById(Long.parseLong(req.getParameter("developed")));
//        Employee checked = employeeInterface.getEmployeeById(Long.parseLong(req.getParameter("checked")));
//        Employee approved = employeeInterface.getEmployeeById(Long.parseLong(req.getParameter("approved")));
//        String isAssembly = req.getParameter("isAssembly");
//        Drawing drawing = new Drawing(null, name, designation, developed, checked, approved,
//                isAssembly.equals("true"));
//        serviceDrawing.addNew(drawing);
//        resp.sendRedirect(req.getContextPath() + "/drawingList");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("names", employeeInterface.getAll());
//        req.getRequestDispatcher("/WEB-INF/jsp/drawing/drawingCreate.jsp").forward(req, resp);
//
//
//    }
//}
