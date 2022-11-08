package spring.boot.rest.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.boot.rest.model.Product;
import spring.boot.rest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByRegex(String regex) {
        return productRepository.findAll().stream().parallel()
                .filter(p -> !p.getName().matches(regex))
                .collect(Collectors.toList());
    }
}
