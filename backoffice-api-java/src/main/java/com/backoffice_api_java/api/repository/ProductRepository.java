package com.backoffice_api_java.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.backoffice_api_java.api.model.Product;
import com.backoffice_api_java.api.model.exception.ResourceNotFoundException;

@Repository
public class ProductRepository {

    private ArrayList<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;

    /***
     * Method to find all products
     * 
     * @return Return a List of products
     */
    public List<Product> getAll() {
        return products;
    }

    /***
     * Method to find a product by Id
     * 
     * @param id Product Id
     * @return Return a product
     */
    public Optional<Product> getById(Integer id) {
        Optional<Product> productFinded = products.stream().filter(product -> product.getId() == id).findFirst();

        if (productFinded.isEmpty()) {
            throw new ResourceNotFoundException("Product not found with specified id");
        }

        return productFinded;
    }

    /***
     * Method to add a product
     * 
     * @param productData data of product
     * @return Return product created
     */
    public Product add(Product productData) {
        lastId++;

        productData.setId(lastId);
        products.add(productData);

        return productData;
    }

    /***
     * Method to update a product
     * 
     * @param productData data of product
     * @return Return product updated
     */
    public Product update(Product productData) {
        Optional<Product> productFinded = getById(productData.getId());

        if (productFinded.isEmpty()) {
            throw new ResourceNotFoundException("Product not found with specified id");
        }

        remove(productData.getId());

        products.add(productData);

        return productData;
    }

    /***
     * Method to remove a product
     * 
     * @param id Product id
     */
    public void remove(Integer id) {
        products.removeIf(product -> product.getId() == id);
    }

}
