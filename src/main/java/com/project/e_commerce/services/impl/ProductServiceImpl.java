package com.project.e_commerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_commerce.model.Product;
import com.project.e_commerce.repositories.ProductRepository;
import com.project.e_commerce.services.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}	

	@Override
	public Iterable<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	@Override
	public Iterable<Product> findOneByBasketId(Integer basketId) {
		return this.productRepository.findByBasketId(basketId);
	}	

	@Override
	public Iterable<Product> findOneByProductName(String productName) {
		return this.productRepository.findByProductName(productName);
	}	
	
	@Override
	public Product findOneByProductId(Integer productId) {
		return this.productRepository.findOne(productId);
	}
	
	@Override
	public Product save(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public void delete(Integer productId) {
		this.productRepository.delete(productId);
	}
}
