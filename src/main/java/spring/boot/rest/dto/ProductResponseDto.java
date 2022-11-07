package spring.boot.rest.dto;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
}
