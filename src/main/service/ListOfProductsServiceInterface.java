package main.service;

import main.dto.ListDTO;
import main.dto.ProductDTO;

import java.util.List;

public interface ListOfProductsServiceInterface {
    ProductDTO createProducts(ProductDTO productDTO);
    ListDTO createList(ListDTO listDTO);
    ListDTO addProductToList(ProductDTO productDTO, Long id);

    List<ListDTO> getAllLists();

    List<ProductDTO> getAllProducts();

}
