package spring.boot.rest.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import spring.boot.rest.dto.ProductResponseDto;
import spring.boot.rest.mapper.DtoResponseMapper;
import spring.boot.rest.model.Product;
import spring.boot.rest.repository.ProductRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceImplTest {
    public static final String REGEX = "^.*[eva].*$";
    public static final Long ID = 1L;
    public static final String NAME = "Ink";
    public static final String DESCRIPTION = "Test description";

    @MockBean
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeAll
    public void setUp() {
        DtoResponseMapper<ProductResponseDto, Product> mapper = Mockito.mock(DtoResponseMapper.class);
        productService = new ProductServiceImpl(productRepository, mapper);
    }

    @Test
    void getProductByRegex_ok() {
        Product product1 = new Product();
        product1.setId(ID);
        product1.setName(NAME);
        product1.setDescription(DESCRIPTION);
        Product product2 = new Product();
        product2.setId(ID);
        product2.setName(REGEX);
        product2.setDescription(DESCRIPTION);
        List<Product> products = List.of(product1, product2);
        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<ProductResponseDto> actual = productService.getProductsByRegex(REGEX);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertFalse(actual.isEmpty());
    }
}