package com.backoffice_api_java.api.controllers;

import java.util.List;
import java.util.Optional;

//#region
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backoffice_api_java.api.model.Product;
import com.backoffice_api_java.api.services.ProductService;
//#endregion

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable("id") Integer id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable("id") Integer id) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Integer id) {
        return productService.remove(id);
    }
}
