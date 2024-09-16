package com.tuts.springTuts.service;

import com.tuts.springTuts.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(101, "Iphone", 50000),
                    new Product(102, "Canon Camera", 70000),
                    new Product(103, "Shure Mic", 10000)
            )
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public Object updateProductById(Product product) {
        products.stream().forEach(p -> {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
            }
        });
        return products;
    }

    public Object deleteProductById(int id) {
        products.removeIf(p -> p.getId() == id);
        return products;
    }
}
