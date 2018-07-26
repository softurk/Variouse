package com.project.e_commerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_commerce.model.Category;
import com.project.e_commerce.repositories.CategoryRepository;
import com.project.e_commerce.services.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public Iterable<Category> findAll() {
		return this.categoryRepository.findAll();
	}

}
