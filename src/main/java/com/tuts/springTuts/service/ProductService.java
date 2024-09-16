package com.tuts.springTuts.service;

import com.tuts.springTuts.model.Product;
import com.tuts.springTuts.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

//    public ProductService() {}
//    public ProductService(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }

//    List<Product> products = new ArrayList<>(
//            Arrays.asList(
//                    new Product(101, "Iphone", 50000),
//                    new Product(102, "Canon Camera", 70000),
//                    new Product(103, "Shure Mic", 10000)
//            )
//    );

    public List<Product> getProducts() {
        try {
            return productRepo.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to find products");
        }
    }

    public Product getProductById(int id) {
        try {
            return productRepo.findById(id).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to retrieve product", e);
        }
    }

    public Object updateProductById(Product product) {
        try {
            productRepo.save(product);
            return productRepo.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update product", e);
        }
    }

    public Object deleteProductById(int id) {
        try {
            if (!productRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
            }
            productRepo.deleteById(id);
            return productRepo.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete product", e);
        }
    }

    public Object addProduct(Product product) {
        System.out.println(product);
        try {
            productRepo.save(product);
            return productRepo.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add product", e);
        }
    }
}
