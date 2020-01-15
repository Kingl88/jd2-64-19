//package by.it.academy.design_bureau.web.servlet;
//
//import by.it.academy.design_bureau.model.Drawing;
//import by.it.academy.design_bureau.service.DrawingService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/drawingList")
//public class DrawingListServlet extends HttpServlet {
//    private final Service<Drawing> serviceDrawing = DrawingService.getService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Drawing> allDrawing = serviceDrawing.getAll();
//        req.setAttribute("drawingList", allDrawing);
//        req.getRequestDispatcher("/WEB-INF/jsp/drawing/drawingList.jsp").forward(req,resp);
//    }
//}
