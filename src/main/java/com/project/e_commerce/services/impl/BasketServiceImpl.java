package com.project.e_commerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_commerce.model.Basket;
import com.project.e_commerce.repositories.BasketRepository;
import com.project.e_commerce.services.BasketService;

@Service("basketService")
public class BasketServiceImpl implements BasketService{

	@Autowired
	private BasketRepository basketRepository;

	
	@Override
	public Iterable<Basket> findAll() {
		return basketRepository.findAll();
	}
	
	@Override
	public Iterable<Basket> findOneByUserId(Integer userId) {
		return this.basketRepository.findByUserId(userId);
	}	
	
	@Override
	public Basket findOneByBasketId(Integer basketId) {
		return basketRepository.findOne(basketId);
	}	

	@Override
	public Basket save(Basket basket) {
		return basketRepository.save(basket);
	}

	@Override
	public void delete(Integer basketId) {
		this.basketRepository.delete(basketId);
	}
}
