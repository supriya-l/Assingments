package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pService;

	@PostMapping("/add")
	public Product newProduct(@RequestBody Product product) {
		return pService.createProduct(product);
	}

	@GetMapping("/getAll")
	public List<Product> allProducts() {
		return pService.getAllProducts();
	}

	@GetMapping("/getById/{id}")
	public Product getById(@PathVariable("id") long productId) {
		return pService.getByProductId(productId);
	}

	@GetMapping("/getByName/{name}")
	public List<Product> getByName(@PathVariable("name") String productName) {
		return pService.getByProductName(productName);

	}

	@GetMapping("/getByType/{type}")
	public List<Product> getByType(@PathVariable("type") String productType) {
		return pService.getByProductType(productType);

	}

	@GetMapping("/getByPrice/{price}")
	public List<Product> getByPrice(@PathVariable("price") double productPrice) {
		return pService.getByProductPrice(productPrice);

	}

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("id") long productId) {
		Product product2 = pService.getByProductId(productId);
		product2.setProductName(product.getProductName());
		product2.setProductType(product.getProductType());
		product2.setProductPrice(product.getProductPrice());
		return pService.updateProduct(product2);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") long productId) {
		return pService.deleteProduct(productId);
	}

}
