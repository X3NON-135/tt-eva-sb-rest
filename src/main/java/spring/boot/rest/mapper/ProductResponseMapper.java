package spring.boot.rest.mapper;

import org.springframework.stereotype.Component;
import spring.boot.rest.dto.ProductResponseDto;
import spring.boot.rest.model.Product;

@Component
public class ProductResponseMapper implements DtoResponseMapper<ProductResponseDto, Product> {

    @Override
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        return productResponseDto;
    }
}
