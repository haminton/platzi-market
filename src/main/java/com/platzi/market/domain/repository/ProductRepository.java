package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getCategory(int categoryId);

    Optional<List<Product>> getScarceProducts(int quantity);

    Optional<Product> getProduct(int productId);

    Product save(Product product);

    public void delete(int productId);
}
