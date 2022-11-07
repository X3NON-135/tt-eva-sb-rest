package spring.boot.rest.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.boot.rest.dto.ProductResponseDto;
import spring.boot.rest.mapper.DtoResponseMapper;
import spring.boot.rest.model.Product;
import spring.boot.rest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final DtoResponseMapper<ProductResponseDto, Product> dtoMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              DtoResponseMapper<ProductResponseDto, Product> dtoMapper) {
        this.productRepository = productRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<ProductResponseDto> getProductsByRegex(String regex) {
        return productRepository.findAll().stream().parallel()
                .filter(p -> !p.getName().matches(regex) && !p.getName().equals(regex))
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
