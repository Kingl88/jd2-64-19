package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final List<Product> products;

    ProductServiceImpl(){
        products = new ArrayList<>();
        products.add(new Product(1L, "Product name 1", 10.0));
        products.add(new Product(2L, "Product name 2", 30.0));
    }
    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void addNewProduct(Product product) {
        product.setId((long) products.size());
        products.add(product);
    }
}
