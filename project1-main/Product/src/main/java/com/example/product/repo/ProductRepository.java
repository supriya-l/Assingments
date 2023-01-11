package com.example.product.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
	Product findByProductId(long productId);

	List<Product> findByProductName(String productName);

	List<Product> findByProductType(String productType);

	List<Product> findByProductPrice(double productPrice);

}
