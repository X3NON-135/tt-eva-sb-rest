package spring.boot.rest.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.rest.dto.ProductResponseDto;
import spring.boot.rest.service.ProductService;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ProductService productService;

    public ShopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductResponseDto> getProductByRegex(@RequestParam String nameFilter) {
        return productService.getProductsByRegex(nameFilter);
    }
}
