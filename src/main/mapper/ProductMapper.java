package main.mapper;

import main.dto.ProductDTO;
import main.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
