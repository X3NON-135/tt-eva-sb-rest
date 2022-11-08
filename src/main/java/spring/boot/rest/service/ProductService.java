package spring.boot.rest.service;

import java.util.List;
import spring.boot.rest.model.Product;

public interface ProductService {
    List<Product> getProductsByRegex(String regex);
}
