package com.project.e_commerce.services;

import com.project.e_commerce.model.Category;

public interface CategoryService {

	//Bütün Kategorileri Getir
	Iterable<Category> findAll();
	
}
