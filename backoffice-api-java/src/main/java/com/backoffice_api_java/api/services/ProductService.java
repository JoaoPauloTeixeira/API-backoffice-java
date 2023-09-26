package com.backoffice_api_java.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backoffice_api_java.api.model.Product;
import com.backoffice_api_java.api.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getById(Integer id) {
        return productRepository.getById(id);
    }

    public Product add(Product product) {
        return productRepository.add(product);
    }

    public Product update(Integer id, Product product) {
        product.setId(id);

        return productRepository.update(product);
    }

    public String remove(Integer id) {
        productRepository.remove(id);

        return "Product has been deleted successfly";
    }
}
