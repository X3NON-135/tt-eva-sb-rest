package spring.boot.rest.service;

import java.util.List;
import spring.boot.rest.dto.ProductResponseDto;

public interface ProductService {
    List<ProductResponseDto> getProductsByRegex(String regex);
}
