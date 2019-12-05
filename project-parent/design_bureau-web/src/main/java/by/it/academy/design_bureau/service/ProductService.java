package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Product;
import sun.plugin2.main.client.PrintBandDescriptor;

import java.util.List;

/**
 * Created by User on 05.12.2019.
 */
public interface ProductService {
    List<Product> getAllProducts();
    void addNewProduct(Product pr);
}
