package by.it.academy.design_bureau.servlet;

import by.it.academy.design_bureau.model.Product;
import by.it.academy.design_bureau.service.ProductService;
import by.it.academy.design_bureau.service.ProductServiceFabric;
import by.it.academy.design_bureau.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 05.12.2019.
 */
@WebServlet(urlPatterns = "/productCreate")
public class ProductCreate extends HttpServlet {

    private ProductService productService = ProductServiceFabric.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/productCreate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String price = req.getParameter("price");
       Product product = new Product(null, name, Double.valueOf(price));
       productService.addNewProduct(product);
       resp.sendRedirect(req.getContextPath() + "/productList");
    }
}
