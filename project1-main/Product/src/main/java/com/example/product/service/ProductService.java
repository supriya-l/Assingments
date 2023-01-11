package com.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repo.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;

	public Product createProduct(Product product) {
		return productRepo.save(new Product(product.getProductId(), product.getProductName(), product.getProductType(),
				product.getProductPrice()));

	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getByProductId(long productId) {
		return productRepo.findByProductId(productId);
	}

	public List<Product> getByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}

	public List<Product> getByProductType(String productType) {
		return productRepo.findByProductType(productType);
	}

	public List<Product> getByProductPrice(double productPrice) {
		return productRepo.findByProductPrice(productPrice);
	}

	public Product updateProduct(Product product) {
		Product uProduct = productRepo.findByProductId(product.getProductId());
		uProduct.setProductName(product.getProductName());
		uProduct.setProductType(product.getProductType());
		uProduct.setProductPrice(product.getProductPrice());

		return productRepo.save(uProduct);
	}

	public String deleteProduct(long productId) {
		productRepo.delete(productRepo.findByProductId(productId));
		return "product deleted";
	}
}
