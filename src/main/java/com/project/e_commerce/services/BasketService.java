package com.project.e_commerce.services;

import com.project.e_commerce.model.Basket;

public interface BasketService {
	
	//Bütün Basket leri Getir
	Iterable<Basket> findAll();
	
	//UserId ye Göre Basket Getir
	Iterable<Basket> findOneByUserId(Integer userId);
	
	//BasketId ye Göre Basket Getir
	Basket findOneByBasketId(Integer basketId);
	
	//Basket Kaydet
	Basket save(Basket basket);
	
	//Basket Sil
	void delete(Integer basketId);
	
}
