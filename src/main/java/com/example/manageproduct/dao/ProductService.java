package com.example.manageproduct.dao;

import com.example.manageproduct.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAllProduct();
    void insertProduct(Product product);
    Product selectProduct(int id);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
List<Product> getProductBySearch(String product);
}
