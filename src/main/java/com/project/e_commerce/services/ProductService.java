package com.project.e_commerce.services;

import com.project.e_commerce.model.Product;


public interface ProductService {
	
	//Bütün Ürünleri Getir
	Iterable<Product> findAll();
	
	//BasketId ye Göre Ürünleri Getir
	Iterable<Product> findOneByBasketId(Integer basketId);
	
	//ProductId ye Göre Ürünleri Getir
	Product findOneByProductId(Integer productId);
	
	//ProductName e Göre Ürünleri Getir
	Iterable<Product> findOneByProductName(String productName);
	
	//Ürün Kaydet
	Product save(Product product);
	
	//ProductId ye Göre Ürün Sil
	void delete(Integer productId);

}
