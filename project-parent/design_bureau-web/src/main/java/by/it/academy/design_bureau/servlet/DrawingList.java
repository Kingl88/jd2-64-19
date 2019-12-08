package by.it.academy.design_bureau.servlet;

import by.it.academy.design_bureau.model_bureau.Drawing;
import by.it.academy.design_bureau.service.Service;
import by.it.academy.design_bureau.service.ServiceDrawing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/drawingList")
public class DrawingList extends HttpServlet {
    private Service<Drawing> serviceDrawing = ServiceDrawing.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Drawing> allDrawing = serviceDrawing.getAll();
        req.setAttribute("drawingList", allDrawing);
        req.getRequestDispatcher("/WEB-INF/jsp/drawingList.jsp").forward(req,resp);
    }
}
