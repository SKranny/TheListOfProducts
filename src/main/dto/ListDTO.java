package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListDTO {
    private Long id;

    private String name;

    private java.util.List<Product> products;

    private Long generalKcal;
}
