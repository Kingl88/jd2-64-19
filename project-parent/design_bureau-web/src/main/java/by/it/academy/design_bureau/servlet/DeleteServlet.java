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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet_del")
public class DeleteServlet extends HttpServlet {
    private Service<Employee> serviceEmployee = ServiceEmployeeImp.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Servlet_del</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<form action=\"servlet_del\">\n" +
                    "Введите id:<input name=\"id\" type=\"text\"><br/>\n" +
                    "<input type=\"submit\"/>\n" +
                    "</form>");
            writer.println("</body>");
            writer.println("</html>");
            doPost(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        serviceEmployee.delete(Long.parseLong(id));
        resp.sendRedirect(req.getContextPath() + "/employeeList");
    }
}
