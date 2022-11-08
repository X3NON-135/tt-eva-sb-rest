package spring.boot.rest.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import spring.boot.rest.dto.ProductResponseDto;
import spring.boot.rest.model.Product;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductResponseMapperTest {
    private ProductResponseMapper mapper;
    private static final Long ID = 1L;
    private static final String NAME = "Test";
    private static final String DESCRIPTION = "Test description";

    @BeforeAll
    public void beforeAll() {
        mapper = new ProductResponseMapper();
    }

    @Test
    public void modelToDto() {
        Product product = new Product();
        product.setId(ID);
        product.setName(NAME);
        product.setDescription(DESCRIPTION);
        ProductResponseDto actual = mapper.toDto(product);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(ID, actual.getId());
        Assertions.assertEquals(NAME, actual.getName());
        Assertions.assertEquals(DESCRIPTION, actual.getDescription());
    }
}
