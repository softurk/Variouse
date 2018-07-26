package com.project.e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.e_commerce.model.Category;


@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
