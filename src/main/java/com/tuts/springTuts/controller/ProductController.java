package com.tuts.springTuts.controller;

import com.tuts.springTuts.model.Product;
import com.tuts.springTuts.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Object getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Object getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Object addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public Object updateProductById(@RequestBody Product product) {
        return productService.updateProductById(product);
    }

    @DeleteMapping("/products/{id}")
    public Object deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);
    }
}
