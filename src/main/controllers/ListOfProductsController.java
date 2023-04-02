package main.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import main.dto.ListDTO;
import main.dto.ProductDTO;
import main.service.ListOfProductsService;
import main.service.ListOfProductsServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/list_of_products")
public class ListOfProductsController {

    private final ListOfProductsServiceInterface listOfProductsService;

    @PostMapping
    @Operation(summary = "Добавление продукта в список")
    public ListDTO addProductToList(ProductDTO productDTO, Long id){
        return listOfProductsService.addProductToList(productDTO,id);
    }

    @GetMapping("/lists")
    @Operation(summary = "Получение всех списков")
    public java.util.List<ListDTO> getAllLists(){
        return listOfProductsService.getAllLists();
    }

    @GetMapping("/products")
    @Operation(summary = "Получение всех продуктов")
    public java.util.List<ProductDTO> getAllProducts(){
        return listOfProductsService.getAllProducts();
    }

    @PostMapping("/create/product")
    @Operation(summary = "Создание и добавление продукта в базу")
    public ProductDTO createProducts(ProductDTO productDTO){
        return listOfProductsService.createProducts(productDTO);
    }

    @PostMapping("/create/list")
    @Operation(summary = "Создание и добавление списка в базу")
    public ListDTO createList(ListDTO listDTO){
        return listOfProductsService.createList(listDTO);
    }

}
