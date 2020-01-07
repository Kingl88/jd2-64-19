//package by.it.academy.design_bureau.web.servlet;
//
//import by.it.academy.design_bureau.model.Drawing;
//import by.it.academy.design_bureau.service.DrawingService;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/del_drawing")
//public class DrawingDeleteServlet extends HttpServlet {
//    private final Service<Drawing> serviceDrawing = DrawingService.getService();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        doPost(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//        String id = req.getParameter("id");
//        serviceDrawing.delete(Long.parseLong(id));
//        resp.sendRedirect(req.getContextPath() + "/drawingList");
//    }
//}
