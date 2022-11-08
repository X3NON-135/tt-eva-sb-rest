package spring.boot.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.rest.dto.ProductResponseDto;
import spring.boot.rest.mapper.DtoResponseMapper;
import spring.boot.rest.model.Product;
import spring.boot.rest.service.ProductService;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ProductService productService;
    private final DtoResponseMapper<ProductResponseDto, Product> mapper;

    public ShopController(ProductService productService,
                          DtoResponseMapper<ProductResponseDto, Product> mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping("/product")
    public List<ProductResponseDto> getProductsByRegex(@RequestParam String nameFilter) {
        return productService.getProductsByRegex(nameFilter)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
