package main.service;

import lombok.RequiredArgsConstructor;
import main.dto.ListDTO;
import main.dto.ProductDTO;
import main.exception.ListException;
import main.mapper.ListMapper;
import main.mapper.ProductMapper;
import main.model.List;
import main.model.Product;
import main.repository.ListRepository;
import main.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListOfProductsService implements ListOfProductsServiceInterface {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final ListMapper listMapper;

    private final ListRepository listRepository;

    @Override
    public ProductDTO createProducts(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.toProduct(productDTO));
        return productMapper.toProductDTO(product);
    }
    @Override
    public ListDTO createList(ListDTO listDTO){
        List list = listRepository.save(listMapper.toList(listDTO));
        return listMapper.toListDTO(list);
    }

    @Override
    public ListDTO addProductToList(ProductDTO productDTO, Long id) {
        ListDTO listDTO = listMapper.toListDTO(listRepository.findById(id)
                .orElseThrow(() -> new ListException("Error! List not Found!")));
        listDTO.getProducts().add(productMapper.toProduct(productDTO));
        listDTO.setGeneralKcal(countGeneralKcal(listDTO));
        return listDTO;
    }

    private Long countGeneralKcal(ListDTO listDTO){
        return listDTO.getProducts().stream()
                .map(Product::getKcal)
                .count();
    }

    @Override
    public java.util.List<ListDTO> getAllLists() {
        return listRepository.findAll().stream()
                .map(listMapper::toListDTO)
                .collect(Collectors.toList());
    }

    @Override
    public java.util.List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

}
