package com.clerodri.productservice.controller;

import com.clerodri.productservice.dto.ProductRequest;
import com.clerodri.productservice.dto.ProductResponse;
import com.clerodri.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
            productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }


}
