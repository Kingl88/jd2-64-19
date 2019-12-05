package by.it.academy.design_bureau.service;

/**
 * Created by User on 05.12.2019.
 */
public class ProductServiceFabric {

    private static ProductService productService;
    public static synchronized ProductService getService(){
        if(productService!= null){
            return  productService;
        } else {
            productService = new ProductServiceImpl();
            return productService;
        }
    }
}
